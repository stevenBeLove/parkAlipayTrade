Ext.define('yzqf',{});
Ext.tree.TreeEditor = function(tree, fc, config){    
	fc = fc || {};    
	var field = fc.events ? fc : new Ext.form.TextField(fc);
	Ext.tree.TreeEditor.superclass.constructor.call(this, field, config);   
	this.tree = tree;    
	if(!tree.rendered){        
		tree.on('render', this.initEditor, this);    
	}else{        
		this.initEditor(tree);   
	}
};//可编辑树的构造函数


/**/

Ext.extend(Ext.tree.TreeEditor, Ext.Editor, {//可以编辑树的继承了编辑器
		   alignment: "l-l",
		   hideEl : false,
		   cls: "x-small-editor x-tree-editor", 
		   shim:false,     
		   maxWidth: 250,
		   editDelay : 350,  
		   myNode:null,
		   initEditor : function(tree){//初始话树节点编辑器
			   
		   		tree.on({//给树的节点加上双击事件
						scope: this,
						beforeclick: this.beforeNodeClick,
						dblclick: this.onNodeDblClick        
						}); 
				
				this.on({//当编辑树的节点完成编辑后
						scope: this, 
						complete: this.updateNode,
						beforestartedit: this.fitToTree,
						specialkey: this.onSpecialKey        
				});        
				this.on('startedit', this.bindScroll, this, {delay:10});    }, //延后10毫秒显示编辑树节点 
				fitToTree : function(ed, el){//自动调整树的大小        
					var td = this.tree.getTreeEl().dom, nd = el.dom;       
					if(td.scrollLeft >  nd.offsetLeft){ 
						td.scrollLeft = nd.offsetLeft;        
					}        
					var w = Math.min(this.maxWidth,(td.clientWidth > 20 ? td.clientWidth : td.offsetWidth) - Math.max(0, nd.offsetLeft-td.scrollLeft) - 5);        
					this.setSize(w, '');    
				},
				triggerEdit : function(node, defer){//编辑开始
					this.myNode = node;
					this.completeEdit();                
					if(node.attributes.editable !== false){//看树的节点是否为编辑状态
						this.editNode = node;            
						if(this.tree.autoScroll){//自动调整树的显示，会有滚动条出现
							Ext.fly(node.ui.getEl()).scrollIntoView(this.tree.body);            
						}            
						var value = node.text || '';            
						if (!Ext.isGecko && Ext.isEmpty(node.text)){//给编辑区域赋空值
							node.setText(' ');            
						}           
						this.autoEditTimer = this.startEdit.defer(this.editDelay, this, [node.ui.textNode, value]);//350毫秒后自动显示编辑区域
						return false;        
					}    
				},
				bindScroll : function(){//绑定计算滚动条高度        
					this.tree.getTreeEl().on('scroll', this.cancelEdit, this);    
				},
				beforeNodeClick : function(node, e){//单击树节点后，没有可以编辑状态  
						return;          
				},    
				onNodeDblClick : function(node, e){//双击该编辑节点后，编辑完成，清理掉this.autoEditTimer  
					clearTimeout(this.autoEditTimer);    
				},
				updateNode : function(ed, value){//编辑成功后，更新树节点        
					this.tree.getTreeEl().un('scroll', this.cancelEdit, this);        
					this.editNode.setText(value);   
				},
				onHide : function(){//隐藏编辑树的节点       
					Ext.tree.TreeEditor.superclass.onHide.call(this);        
					if(this.editNode){            
						this.editNode.ui.focus.defer(50, this.editNode.ui);       
					}    
				},
				onSpecialKey : function(field, e){//添加键盘事件        
					var k = e.getKey();        
					if(k == e.ESC){//键盘ESC取消事件
						e.stopEvent();           
						this.completeEdit();        
					}else if(k == e.ENTER && !e.hasModifier()){//回车完成编辑            
						e.stopEvent();           
						this.completeEdit();       
					}    
				},       
				onDestroy : function(){//销毁编辑节点        
					clearTimeout(this.autoEditTimer);        
					Ext.tree.TreeEditor.superclass.onDestroy.call(this);        
					var tree = this.tree;       
					tree.un('beforeclick', this.beforeNodeClick, this);       
					tree.un('dblclick', this.onNodeDblClick, this);    
				},
			    completeEdit : function(remainVisible){//完成编辑执行
			        if(!this.editing){
			            return;
			        }
			        
			        var v = this.getValue();
//			        if(!this.field.isValid()){
//			            if(this.revertInvalid !== false){
//			                this.cancelEdit(remainVisible);
//			            }
//			            return;
//			        }
			        if(String(v) === String(this.startValue) && this.ignoreNoChange){
			            this.hideEdit(remainVisible);
			            return;
			        }
			        if(this.fireEvent("beforecomplete", this, v, this.startValue) !== false){
			            v = this.getValue();
			            if(this.updateEl && this.boundEl){
			                this.boundEl.update(v);
			            }
			            this.hideEdit(remainVisible);
			            this.fireEvent("complete", this, v, this.startValue);
			        }
			    }
			});

/**/
newtree = Ext.extend(Ext.tree.TreePanel, {
	 contextMenu:true                             //右键菜单
	,deleteText:'删除'           				  //删除按钮文字
	,insertText:'新建'                             //新增按钮文字
	,newText:''                                   //新增编辑节点的里面显示的值
	,reallyWantText:'您想删除该节点吗?'              //删除操作的提示 
	,renameText:'编辑'
	,myOpUrl:{                                    //配置右键菜单的按钮操作
			'renameNode':'',                      //编辑
			'removeNode':'',                      //删除
			'insertChild':''                      //新增
	}
    ,border:false
    
	,cmdNames:{//操作的名称
	     renameNode:'renameTreeNode'
		,removeNode:'removeTreeNode'
		,insertChild:'insertTreeChild'
	}
	
	,deleteIconCls:'tree_menu_delete'             //删除操作按钮的小图标

	,editable:true                                //是否为编辑状态

	,editorConfig:{                               //编辑器的初始状态的配置
		 cancelOnEsc:true                         //ESC取消编辑时间激活
		,completeOnEnter:true                     //ENTER完成编辑激活
	}

	,editorFieldConfig:{                          //编辑域的初始配置
		 allowBlank:false                         //设定初始值不能为空
		,selectOnFocus:false                      //编辑域选中就可编辑
		,blankText:'不允许为空'                     //为空值的提示
	}
	
	,enableDD:false                               //是否可以拖动
	
	,insertIconCls:'tree_menu_add'                //新建操作按钮的小图标

	,layout:'fit'                                 //树布局是自适应

	,paramNames:{                                 //每次请求action的参数
		cmd:'',                                   //可以变动的参数
		'renameNode':{                            //编辑的参数
			 id:'',
			 name:''
		},
		'removeNode':{                            //删除的参数
			 id:''
		},
		'insertChild':{                           //新增的参数
			 id:'',
			 name:''
		}
	}
	
	,renameIconCls:'tree_menu_edit'               //编辑操作按钮的小图标    

    ,initComponent:function() {                   //初始换组件

        var config = {};

		if(!this.keys) {
			config.keys = (function() {                 //添加键盘事件
				var keys = [];
				if(true === this.editable) {
					keys.push({
						 key:Ext.EventObject.DELETE     //delete删除事件
						,scope:this
						,stopEvent:true
						,handler:this.onKeyDelete
					});

					keys.push({                         //F2编辑事件
						 key:Ext.EventObject.F2
						,scope:this
						,stopEvent:true
						,handler:this.onKeyEdit
					});
				}
				return keys;
			}.call(this));
		}
 
        
        Ext.apply(this, Ext.apply(this.initialConfig, config));       //加入树初始化的配置
        
        newtree.superclass.initComponent.apply(this, arguments);
        
       	this.addListener('dblclick', function(node,e) {
	  		return;
	    }, this);

	    
		if(true === this.loader.preloadChildren){ //预加载孩子节点
			this.loader.on({load:function(loader, node) {
				node.cascade(function(n) {
					loader.doPreload(n);
				});
			}});
		}
			
		if(true === this.editable && !this.editor) {//处于编辑状态且编辑器已经存在
			this.editor = new Ext.tree.TreeEditor(this, this.editorFieldConfig, this.editorConfig);
			this.editor.on({
				 complete:{scope:this, fn:this.onEditComplete}
				,beforestartedit:{scope:this, fn:function(){ return this.editable; }}
			});
		}
        
		if(true === this.editable) {//获得选中节点
			this.getSelectionModel().on({
				selectionchange:{scope:this, fn:function(selModel, node) {
					this.selectedNode = node;
				}
			}});
		}

		if(true === this.editable && !this.actions) {//预配置右键菜单的操作按钮及操作
			this.actions = {
				renameNode:new Ext.Action({
					 text:this.renameText             //编辑按钮显示的文字
					,iconCls:this.renameIconCls       //编辑按钮显示的小图标
					,scope:this                       //作用域
					,handler:this.onRenameNode        //处理方法
				})
				,removeNode:new Ext.Action({          //删除同上
					 text:this.deleteText
					,iconCls:this.deleteIconCls
					,scope:this
					,handler:this.onRemoveNode
				})
				,insertChild:new Ext.Action({         //新增同上
					 text:this.insertText
					,iconCls:this.insertIconCls
					,scope:this
					,handler:this.onInsertChild
				})
			};
		}

		
		if(true === this.editable && true === this.contextMenu) {  //初始右键菜单
			this.contextMenu = new Ext.menu.Menu([
				 this.actions.insertChild
				,this.actions.renameNode
				,this.actions.removeNode
			]);
		}

		if(this.contextMenu) {//如果右键菜单已经完成
			this.on({contextmenu:{scope:this, fn:this.onContextMenu, stopEvent:true}}); //给树加上右键菜单事件
			this.contextMenu.on({    
				hide:{scope:this, fn:function() {//当右键菜单隐藏时，编辑节点对应为空
					this.actionNode = null;
				}}
				,show:{scope:this, fn:function() {//当右键菜单显示时，获取编辑节点
					var node = this.actionNode;
					var text = Ext.util.Format.ellipsis(node ? node.text : '', 12);
					this.contextMenu.el.shadow.hide();
					this.contextMenu.el.shadow.show(this.contextMenu.el);
				}}
			});
		}
		// }}}
		// {{{
		// add events
		this.addEvents(
			/**
			 * @event beforeremoverequest
			 * Fires before request is sent to the server, return false to cancel the event.
			 * @param {newtree} tree This tree panel
			 * @param {Object} options Options as passed to Ajax.request
			 */
			 'beforeremoverequest'

			/**
			 * @event beforerenamerequest
			 * Fires before request is sent to the server, return false to cancel the event.
			 * @param {newtree} tree This tree panel
			 * @param {Object} options Options as passed to Ajax.request
			 */
			,'beforerenamerequest'

			/**
			 * @event beforeappendrequest
			 * Fires before request is sent to the server, return false to cancel the event.
			 * @param {newtree} tree This tree panel
			 * @param {Object} options Options as passed to Ajax.request
			 */
			,'beforeappendrequest'

			/**
			 * @event beforeinsertrequest
			 * Fires before request is sent to the server, return false to cancel the event.
			 * @param {newtree} tree This tree panel
			 * @param {Object} options Options as passed to Ajax.request
			 */
			,'beforeinsertrequest'

			/**
			 * @event beforeremoverequest
			 * Fires before request is sent to the server, return false to cancel the event.
			 * @param {newtree} tree This tree panel
			 * @param {Object} options Options as passed to Ajax.request
			 */
			,'beforemoverequest'

			/**
			 * @event appendchildsuccess
			 * Fires after server returned success
			 * @param {newtree} tree This tree panel
			 * @param {Ext.tree.AsyncTreeNode} node The node involved in action
			 */
			,'appendchildsuccess'

			/**
			 * @event insertchildsuccess
			 * Fires after server returned success
			 * @param {newtree} tree This tree panel
			 * @param {Ext.tree.AsyncTreeNode} node The node involved in action
			 */
			,'insertchildsuccess'

			/**
			 * @event removenodesuccess
			 * Fires after server returned success
			 * @param {newtree} tree This tree panel
			 * @param {Ext.tree.AsyncTreeNode} node The node involved in action
			 */
			,'removenodesuccess'

			/**
			 * @event renamenodesuccess
			 * Fires after server returned success
			 * @param {newtree} tree This tree panel
			 * @param {Ext.tree.AsyncTreeNode} node The node involved in action
			 */
			,'renamenodesuccess'

			/**
			 * @event movenodesuccess
			 * Fires after server returned success
			 * @param {newtree} tree This tree panel
			 * @param {Ext.tree.AsyncTreeNode} node The node involved in action
			 */
			,'movenodesuccess'
		);

    } 

	,initEvents:function() { //私有属性，初始节点拖动事件
		newtree.superclass.initEvents.apply(this, arguments);
		if(true === this.enableDD) {
			this.dragZone.onBeforeDrag = function(data, e) {
				var n = data.node;
				return n && n.draggable && !n.disabled && this.tree.editable;
			}; 
		}
	}
	
	,actionCallback:function(options, success, response) {//所有操作完成后的回调函数

		if(options.node) {
			options.node.getUI().afterLoad();
		}

		// {{{
		// failure handling
		if(true !== success) {//如果请求失败，给提示
			this.showError('提示信息',response.responseText);
			return;
		}
		var o;
		try {//请求成功后，将返回的结果转为json格式
			o = Ext.decode(response.responseText);
		}
		catch(ex) {
			this.showError('提示信息',response.responseText);
			return;
		}
		if(true !== o.success) {//如果返回失败的话
			this.showError('提示信息',o.message);
			switch(options.action) {
				case 'appendChild':
				case 'insertChild':
					options.node.parentNode.removeChild(options.node); //直接删除节点
				break;

				default:
				break;
			}
			return;
		}
		
		if(!options.action) {
			this.showError('提示信息','操作失败，请稍候再试！');
		}

		switch(options.action) {//成功的操作
			case 'renameNode':
				var newt = '';
				if(typeof options.params.name != 'undefined'){//根据参数不同，重新设置节点的显示值
					newt = options.params.name;
				}
				if(typeof options.params.directoryName != 'undefined'){
					newt = options.params.directoryName;
				}
				if(typeof options.params['org.name'] != 'undefined'){
					newt = options.params['org.name'];
				}
				options.node.setText(newt);
				Ext.example.msg('提示信息',o.message);
			break;

			case 'removeNode':
				options.node.parentNode.removeChild(options.node);
				Ext.example.msg('提示信息',o.message);
			break;
			case 'insertChild':
				this.unregisterNode(options.node);        //释放编辑节点
				options.node.id = o.id;
				Ext.fly(options.node.getUI().elNode).set({'ext:tree-node-id':o.id});  //给新的节点赋予新增的id
				options.node.attributes['createAble'] = options.node.parentNode.attributes['createAble'];
				options.node.attributes['deleteAble'] = options.node.parentNode.attributes['deleteAble'];
				options.node.attributes['updateAble'] = options.node.parentNode.attributes['updateAble'];
				this.registerNode(options.node);                                      //重新注册该节点
				options.node.select();                                                //选中该节点
				Ext.example.msg('提示信息',o.message);
			break;
		}
		//}}}
		this.fireEvent(options.action.toLowerCase() + 'success', this, options.node);

	}  
	
	,applyBaseParams:function(params) { //给回调函数配置参数
		var o = Ext.apply({}, this.baseParams || this.loader.baseParams || {});
		Ext.apply(o, params || {});
		return o;
	}
 
	,appendChild:function(childNode, insert) {//增加汉字节点

		var o = Ext.apply(this.getOptions(), {
			 action:true === insert ? 'insertChild' : 'appendChild'
			,node:childNode
			,params:{}
		});
		if(!Ext.util.Format.trim(childNode.text)){
			childNode.parentNode.removeChild(childNode);
			return;
		}
		o.url = this.myOpUrl[o.action];
		var params = this.applyBaseParams();
		if(!params[this.paramNames.cmd]){
			params[this.paramNames[o.action].cmd] = this.paramNames.cmd;
		}
		params[this.paramNames[o.action].id] = childNode.parentNode.id;
		params[this.paramNames[o.action].name] = childNode.text;
		o.params = params;

		if(false !== this.fireEvent('before' + (insert ? 'insert' : 'append') + 'request', this, o)) {
			
			childNode.getUI().beforeLoad();
			Ext.Ajax.request(o);
			
		}
	} 
	
	,getOptions:function() {//配置ajax请求的参数
		return {
			 url:''
			,method:this.loader.method || this.method || 'POST'
			,scope:this
			,callback:this.actionCallback
		};
	}  
	
	,onAppendChild:function(insert) {//当编辑时候
		this.actionNode = this.actionNode || this.selectedNode;
		if(!this.actionNode) {
			return;
		}
		var node = this.actionNode;
		var child;
		node.leaf = false;
		node.expand(false, false, function(n) {
			if(true === insert) {
				child = n.insertBefore(this.loader.createNode({text:this.newText,leaf:true,loaded:false}), n.firstChild);
			}
			else {
				child = n.appendChild(this.loader.createNode({text:this.newText,leaf:true,loaded:true}));
			}
		}.createDelegate(this)); //插入编辑节点

		this.editor.creatingNode = true;
		
		if(true === insert) {
			this.editor.on({complete:{scope:this, single:true, fn:this.onInsertEditComplete}});
		}
		else {
			this.editor.on({complete:{scope:this, single:true, fn:this.onAppendEditCompete}});
		}

		this.editor.triggerEdit(child);  //编辑该节点
		this.actionNode = null;

	} 
	
	,onAppendEditCompete:function(editor, newText, oldText) {//当完成编辑后
		this.appendChild(editor.editNode);
	}

	,onBeforeNodeDrop:function(e) {//在拖到之前

		this.moveNode(e);
		e.dropStatus = true;
		return false;

	} 
	
	,onContextMenu:function(node, e) {  //当右键菜单操作的树
		var menu = this.contextMenu;
		if(node.browserEvent) {
			this.getSelectionModel().clearSelections();
			this.actionNode = this.getRootNode();
			node.stopEvent();
		}
		else {
			node.select();
			this.actionNode = node;
			menu.showAt(e.getXY());
			e.stopEvent();
		}

		var actions = this.actions;
		var disable = true !== this.editable || !this.actionNode;
		
		if(node.id == 1 || node.attributes['rt']){//右键菜单根据权限判断是否可以操作
			
			if(node.attributes['createAble'] == 1){
				actions.insertChild.enable();
			}else if(node.attributes['createAble'] == '2'){
				actions.insertChild.disable();
			}else if(node.attributes['createAble'] == '3'){
				actions.insertChild.hide();
			}//新建
			
			actions.renameNode.disable();
			actions.removeNode.disable();
			
		}else{
			if(node.attributes['createAble'] == 1){
				actions.insertChild.enable();
			}else if(node.attributes['createAble'] == '2'){
				actions.insertChild.disable();
			}else if(node.attributes['createAble'] == '3'){
				actions.insertChild.hide();
			}//新建
			
												
			if(node.attributes['updateAble'] == '1'){
				actions.renameNode.enable();
			}else if(node.attributes['updateAble'] == '2'){
				actions.renameNode.disable();
			}else if(node.attributes['updateAble'] == '3'){
				actions.renameNode.hide();
			}//编辑 
			
			if(node.attributes['deleteAble'] == '1'){
				actions.removeNode.enable();
			}else if(node.attributes['deleteAble'] == '2'){
				actions.removeNode.disable();
			}else if(node.attributes['deleteAble'] == '3'){
				actions.removeNode.hide();
			}//删除 

		}

	} 

	,onEditComplete:function(editor, newText, oldText) {//ENTER事件操作
		if(editor.creatingNode) {
			editor.creatingNode = false;
			return;
		}
		this.renameNode(editor.editNode,newText,oldText);
		return false;
	}
	
	,onExpandAll:function() {
		this.getRootNode().expand(true, false);
	} 
	
	,onExpandNode:function() {
		(this.actionNode || this.selectedNode || this.getRootNode()).expand(true, false);
	} 

	,onCollapseAll:function() {
		this.getRootNode().collapse(true, false);
	}

	,onCollapseNode:function() {
		(this.actionNode || this.selectedNode || this.getRootNode()).collapse(true, false);
	} 

	,onInsertEditComplete:function(editor, newText, oldText) {//当新增操作编辑完成后
		this.appendChild(editor.editNode, true);
	} 
	
	,onInsertChild:function() {  //当新增节点后
		this.onAppendChild(true);
	}

	,onKeyDelete:function(key, e) {//当按下delete键，删除操作
		this.actionNode = this.getSelectionModel().getSelectedNode();
		if(this.actionNode.id != 1 && !this.actionNode.attributes['rt']){
			this.actions.removeNode.execute();
		}
	}

	,onKeyEdit:function(key, e) {//当按下enter键，完成编辑操作
		var node = this.getSelectionModel().getSelectedNode();
		if(node && true === this.editable && node.id != 1 && !node.attributes['rt']) {
			this.actionNode = node;
			this.onRenameNode();
		}
	}

	,onRender:function() {//树的渲染
		newtree.superclass.onRender.apply(this, arguments);
		if(false === this.rootVisible && this.contextMenu) {
			this.el.on({contextmenu:{scope:this, fn:this.onContextMenu, stopEvent:true}});
		}
	}

	,onRemoveNode:function() {//删除操作
		this.actionNode = this.actionNode || this.selectedNode;
		if(!this.actionNode) {
			return;
		}
		var node = this.actionNode;
		this.removeNode(node);
		this.actionNode = null;
	} 

	,onRenameNode:function() {//编辑操作
		this.actionNode = this.actionNode || this.selectedNode;
		if(!this.actionNode) {
			return;
		}
		var node = this.actionNode;
		this.editor.triggerEdit(node, 10);
		this.actionNode = null;
	}
	
	,removeNode:function(node) {//删除操作
		if(0 === node.getDepth()) {
			return;
		}
		Ext.Msg.show({
			 title:'提示信息'
			,msg:this.reallyWantText
			,buttons:Ext.Msg.YESNO
			,scope:this
			,fn:function(response) {
				if('yes' !== response) {
					return;
				}

				var o = Ext.apply(this.getOptions(), {
					 action:'removeNode'
					,node:node
					,params:{}
				});
				
				o.url = this.myOpUrl[o.action];
				
				var params = this.applyBaseParams();
				if(!params[this.paramNames.cmd]){
					params[this.paramNames[o.action].cmd] = this.paramNames.cmd;
				}
				params[this.paramNames[o.action].id] = node.id;
				o.params = params;

				if(false !== this.fireEvent('beforeremoverequest', this, o)) {
					node.getUI().beforeLoad();
					Ext.Ajax.request(o);
				}
			}
		});
	} 
	
	,renameNode:function(node,newText,oldText) {//编辑操作

		var o = Ext.apply(this.getOptions(), {
			 action:'renameNode'
			,node:node
			,params:{}
		});
		
		if(!Ext.util.Format.trim(newText)){
			node.setText(oldText);
			return;
		}
		
		if(newText == oldText){
			node.setText(oldText);
			return;
		}
		
		o.url = this.myOpUrl[o.action];
		
	var params = this.applyBaseParams();
	
		if(!params[this.paramNames.cmd]){
				params[this.paramNames[o.action].cmd] = this.paramNames.cmd;
		}
		
		params[this.paramNames[o.action].id] = node.id;
		params[this.paramNames[o.action].name] = Ext.util.Format.trim(newText);
		o.params = params;

		if(false !== this.fireEvent('beforerenamerequest', this, o)) {
			node.getUI().beforeLoad();
			Ext.Ajax.request(o);
		}

	}

	,showError:function(msg, title) {//报错信息
		Ext.example.msg(title,msg);
	} 

});
// 注册树组件
Ext.reg('remotetreepanel', newtree); 
 
 $(function() {

     $('.datepicker').datetimepicker({
         language: 'zh-CN',
         showButtonPanel: true,
         maxDate: null,
         dateFormat: 'yy-mm-dd',
         timeFormat: 'HH:mm:ss',
         stepHour: 1,
         stepMinute: 1,
         stepSecond: 1
     });
 })
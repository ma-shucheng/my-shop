var App = function () {

    var _masterCheckbox ;
    var _checkbox ;


    /**
     * 私有方法，初始化ICheck
     */
    var handlerInitCheckbox = function () {
        //Flat red color scheme for iCheck
        $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
            checkboxClass: 'icheckbox_flat-green',
            radioClass: 'iradio_flat-green'
        });

        //获取控制端Checkbox
        _masterCheckbox = $('input[type="checkbox"].flat-red.icheck_master');

        _checkbox = $('input[type="checkbox"].flat-red');
    };

    /**
     * Checkbox的全选功能
     */
    var handlerCheckboxAll = function(){
        _masterCheckbox.on("ifClicked",function (e) {
            //未选中状态
            if (e.target.checked) {
                _checkbox.iCheck("uncheck");
            }
            //选中状态
            else {
                _checkbox.iCheck("check");
            }
        });
    };

    /**
     * 批量删除
     * @param url
     */
    var handlerDeleteMulti = function (url) {
        //新建数组存放选中ID号
        _idArray = new Array();

        //将选中元素的ID放入数组
        _checkbox.each(function () {
            var _id = $(this).attr("id");
            if (_id != null && _id != "undefine" && $(this).is(":checked")){
                _idArray.push(_id);
            }
        });
        //如果没有选择一个项目，则弹出对话框提示
        if (_idArray.length == 0) {
            $("#modal-noselect").modal("show");

        }
        $.ajax({
            "url": url,
            "type":"POST",
            "data":{"ids":_idArray.toString()},
            "dataType":"JSON",
            "success": function (data) {
                if (data.status == 200) {
                    //展示成功界面
                    $("#modal-delete-success").modal("show");
                }
            }
        });
    };

    /**
     * 重启刷新初始化页面
     */
    var handlerReboot = function () {
        _masterCheckbox.iCheck("uncheck");
        _checkbox.iCheck("uncheck");
        window.location.reload();
    };

    return {
        init: function () {
            handlerInitCheckbox();
            handlerCheckboxAll();
        },
        getCheckbox: function () {
            return _checkbox;
        },
        deleteMulti: function(url){
            handlerDeleteMulti(url);
        },
        reboot: function () {
            handlerReboot();
        }
    }
}();
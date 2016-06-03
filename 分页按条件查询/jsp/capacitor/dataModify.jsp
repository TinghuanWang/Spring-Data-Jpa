<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@page isELIgnored="false" %>
<form id="ff" action="/csmis/capacitor/save.action" method="post">
    <table style="width:650px;height:400px;">
        <tr style="display: none">
            <td>id</td>
            <td><input class="easyui-validatebox" type="text" name="nId" data-options="required:false"
                       value="${map.NId}"/>
            </td>
        </tr>
        <tr style="display: none">
            <td>id</td>
            <td><input class="easyui-validatebox" type="text" name="vcStatus" data-options="required:false"
                       value="0"/>
            </td>
        </tr>
        <tr>
            <td>发现时间:</td>
            <td><input class="easyui-datebox" name="dtFind"
                       data-options="formatter:myformatter,parser:myparser,required:true"
                       value="${map.dtFind}"/>
            </td>
        </tr>
        <tr>
            <td>线别:</td>
            <td>
                <input type="hidden" id="line_hide" value="${map.line}"/>
                <select class="easyui-validatebox" data-options="required:true" style="width:150px" name="line"
                        id="line">
                </select></td>
        </tr>
        <tr>
            <td>车间:</td>
            <td>
                <input type="hidden" id="workshop_hide" value="${map.workshop}"/>
                <select class="easyui-validatebox" data-options="required:true" style="width:150px" name="workshop"
                        id="workshop" onchange="changeWs('workshop','workarea')">
                </select></td>
        </tr>
        <tr>
            <td>工区:</td>
            <td>
                <select class="easyui-validatebox" data-options="required:true" style="width:150px" name="workarea"
                        id="workarea" onchange="changeWa('workarea','station')">
                </select></td>
        </tr>
        <tr>
            <td>车站:</td>
            <td>
                <select class="easyui-validatebox" data-options="required:true" style="width:150px" name="station"
                        id="station">
                </select></td>
        </tr>
        <tr>
            <td>区间:</td>
            <td><input class="easyui-validatebox" type="text" name="sector"
                       data-options="required:true" value="${map.sector}"/></td>
        </tr>
        <tr>
            <td>失效电容:</td>
            <td><input class="easyui-validatebox" type="text" name="loseCapacitor"
                       data-options="required:true" value="${map.loseCapacitor}"/></td>
        </tr>
        <tr>
            <td>标准容量:</td>
            <td><input class="easyui-validatebox" type="text" name="rlStandard"
                       data-options="required:true" value="${map.rlStandard}"/></td>
        </tr>
        <tr>
            <td>更换前容量:</td>
            <td><input class="easyui-validatebox" type="text" name="rlBefore"
                       data-options="required:true" value="${map.rlBefore}"/></td>
        </tr>
        <tr>
            <td>更换前电压:</td>
            <td><input class="easyui-validatebox" type="text" name="dyBefore"
                       data-options="required:true" value="${map.dyBefore}"/></td>
        </tr>
        <tr>
            <td>更换前电流:</td>
            <td><input class="easyui-validatebox" type="text" name="dlBefore"
                       data-options="required:true" value="${map.dlBefore}"/></td>
        </tr>
        <tr>
            <td>更换前厂家:</td>
            <td><input class="easyui-validatebox" type="text" name="factoryBefore"
                       data-options="required:true" value="${map.factoryBefore}"/></td>
        </tr>
        <tr>
            <td>备注:</td>
            <td>
                <textarea name="note" style="height:60px;">${map.note}</textarea>
            </td>
        </tr>
        <tr>
            <td>电容类型:</td>
            <td>
                <select class="easyui-validatebox" data-options="required:true" style="width:150px"
                        name="vcType">
                    <option value="">请选择</option>
                    <option value="0">电容上行</option>
                    <option value="1">电容下行</option>
                </select></td>
        </tr>
    </table>
</form>
<div style="text-align:center;padding: 5px">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="submitForm()">提交</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-back" onclick="clearForm()">重置</a>
</div>
<script type="text/javascript">
    $(function () {
        var line = $('#line_hide').val();
        var workshop = $('#workshop_hide').val();
        initLine("line",line);
        initChejian("workshop",workshop);
        changeWs('workshop','workarea');
        changeWa('workarea','station');
    });
    function submitForm() {
        $.messager.confirm('提示', '你确定要提交记录吗？', function (r) {
            if (r) {
                $('#ff').form('submit', {
                    success: function () {
                        $('#win-show').dialog('close');
//                        $.messager.alert('提示', '提交成功！！', 'info');
                        getInitData();
                    }
                });
            }

        });
    }
    function clearForm() {
        $('#ff').form('clear');
    }

    function myformatter(date) {
        var y = date.getFullYear();
        var m = date.getMonth() + 1;
        var d = date.getDate();
        return y + '/' + (m < 10 ? ('0' + m) : m) + '/' + (d < 10 ? ('0' + d) : d);
    }
    function myparser(s) {
        if (!s) return new Date();
        var ss = (s.split('/'));
        var y = parseInt(ss[0], 10);
        var m = parseInt(ss[1], 10);
        var d = parseInt(ss[2], 10);
        if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {
            return new Date(y, m - 1, d);
        } else {
            return new Date();
        }
    }
</script>

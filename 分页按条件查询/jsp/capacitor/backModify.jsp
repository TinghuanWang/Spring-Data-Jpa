<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@page isELIgnored="false" %>
<div class="easyui-accordion" style="width:650px;height:590px;">
    <div title="基础信息" data-options="iconCls:'icon-tip'" style="overflow:auto;padding:10px;">
        <div style="padding:10px 0 10px 100px;background-color: #E2E8EE">
            <table style="width:400px;height:420px;text-align:center;">
                <tr>
                    <td>发现时间:</td>
                    <td><label>${map.dtFind}</label>
                    </td>
                </tr>
                <tr>
                    <td>线 别:</td>
                    <td>
                        ${map.line}</td>
                </tr>
                <tr>
                    <td>车 间:</td>
                    <td>${map.workshop}</td>
                </tr>
                <tr>
                    <td>工 区:</td>
                    <td>${map.workarea}</td>
                </tr>
                <tr>
                    <td>车 站:</td>
                    <td>${map.station}</td>
                </tr>
                <tr>
                    <td>区间:</td>
                    <td>${map.sector}</td>
                </tr>
                <tr>
                    <td>失效电容:</td>
                    <td>${map.loseCapacitor}</td>
                </tr>
                <tr>
                    <td>标准容量:</td>
                    <td>${map.rlStandard}</td>
                </tr>
                <tr>
                    <td>更换前容量:</td>
                    <td>${map.rlBefore}</td>
                </tr>
                <tr>
                    <td>更换前电压:</td>
                    <td>${map.dyBefore}</td>
                </tr>
                <tr>
                    <td>更换前电流:</td>
                    <td>${map.dlBefore}</td>
                </tr>
                <tr>
                    <td>更换前厂家:</td>
                    <td>${map.factoryBefore}</td>
                </tr>
                <tr>
                    <td>电容类型:</td>
                    <td>${map.vcType}</td>
                </tr>
                <tr>
                    <td>状态:</td>
                    <td>${map.vcStatus}</td>
                </tr>
                <tr>
                    <td>备 注:</td>
                    <td>
                        ${map.note}
                    </td>
                </tr>
            </table>
        </div>
    </div>
    <div title="填写反馈信息" data-options="iconCls:'icon-tip'" style="padding:10px;">
        <div style="padding:10px 0 10px 100px;background-color: #E2E8EE">
            <form id="ff" action="/csmis/capacitor/saveBack.action" method="post">
                <table style="width: 100%;height: auto">
                    <input type="hidden" value="${map.NId}" name="nId"/>
                    <input type="hidden" value="1" name="vcStatus"/>
                    <tr>
                        <td>更换后电容用量:</td>
                        <td><input class="easyui-validatebox" type="text" name="rlAfter"
                                   data-options="required:true"></input></td>
                    </tr>
                    <tr>
                        <td>更换后电容电压:</td>
                        <td><input class="easyui-validatebox" type="text" name="dyAfter"
                                   data-options="required:true"></input></td>
                    </tr>
                    <tr>
                        <td>更换后电容电流:</td>
                        <td><input class="easyui-validatebox" type="text" name="dlAfter"
                                   data-options="required:true"></input></td>
                    </tr>
                    <tr>
                        <td>更换后厂家:</td>
                        <td><input class="easyui-validatebox" type="text" name="factoryAfter"
                                   data-options="required:true"></input></td>
                    </tr>
                    <tr>
                        <td>检测测试情况:</td>
                        <td><textarea name="testCondition" style="height:60px;"></textarea></td>
                    </tr>
                    <tr>
                        <td>处理情况:</td>
                        <td><textarea name="dealCondition" style="height:60px;"></textarea></td>
                    </tr>
                    <tr>
                        <td>处理人:</td>
                        <td><input class="easyui-validatebox" type="text" name="dealUser"
                                   data-options="required:true"></input></td>
                    </tr>
                    <tr>
                        <td>检测部门:</td>
                        <td>
                            <input class="easyui-validatebox" type="text" name="testDepartment"
                                   data-options="required:true"></input>
                        </td>
                    </tr>
                </table>
            </form>
            <div style="text-align:center;padding: 5px">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="submitForm()">提交</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-back" onclick="clearForm()">重置</a>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
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
</script>

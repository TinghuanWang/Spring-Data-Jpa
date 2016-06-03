<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<html lang="zh-CN">
<head>
    <title>安全电容监测数据反馈列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <script type="text/javascript" src="/csmis/js/public.js" charset="GBK"></script>
    <link rel="stylesheet" type="text/css" href="/csmis/js/jquery-easyui-1.4.1/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/csmis/js/jquery-easyui-1.4.1/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/csmis/js/jquery-easyui-1.4.1/demo/demo.css">
    <script type="text/javascript" src="/csmis/js/jquery-easyui-1.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="/csmis/js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/csmis/safe/capacitor/opration.js"></script>
</head>
<!--[if lte IE 9]>
<script type="text/javascript" src="/csmis/newjs/html5.min.js"></script>
<script type="text/javascript" src="/csmis/newjs/respond.min.js"></script>
<![endif]-->
<body style="width: 100%;height: 100%">
<div style="margin:10px 0;"></div>
<table class="easyui-datagrid" title="安全电容监测数据反馈列表" style="width: 98%;height: 720px" id="dataTab"
       data-options="singleSelect:true,
       pagination:true,
       pageSize: 20,
       url:'/csmis/capacitor/initAll.action',
       loadMsg:'正在努力的为你加载数据...',
       selectOnCheck:true,
       fitColumns:false,
       nowrap:false,
       rownumbers:true,
       toolbar:'#tb'">
    <thead>
    <tr>
        <th data-options="field:'ck',checkbox:true"></th>
        <th data-options="field:'NID',width:50">编号</th>
        <th data-options="field:'DTFIND',width:100">发现时间</th>
        <th data-options="field:'LINE',width:80,align:'center'">线别</th>
        <th data-options="field:'WORKSHOP',width:80,align:'center'">车间</th>
        <th data-options="field:'WORKAREA',width:80,align:'center'">工区</th>
        <th data-options="field:'STATION',width:80,align:'center'">车站</th>
        <th data-options="field:'SECTOR',width:80,align:'center'">区间</th>
        <th data-options="field:'LOSECAPACITOR',width:80,align:'center'">失效电容</th>
        <th data-options="field:'RLSTANDARD',width:50,align:'center'">标准容量</th>
        <th data-options="field:'RLBEFORE',width:50,align:'center'">更换前容量</th>
        <th data-options="field:'DYBEFORE',width:50,align:'center'">更换前电压</th>
        <th data-options="field:'DLBEFORE',width:50,align:'center'">更换前电流</th>
        <th data-options="field:'FACTORYBEFORE',width:80,align:'center'">更换前厂家</th>
        <th data-options="field:'RLAFTER',width:50,align:'center'">更换后容量</th>
        <th data-options="field:'DYAFTER',width:50,align:'center'">更换后电压</th>
        <th data-options="field:'DLAFTER',width:50,align:'center'">更换后电流</th>
        <th data-options="field:'FACTORYAFTER',width:80,align:'center'">更换后厂家</th>
        <th data-options="field:'TESTCONDITION',width:150,align:'center'">检测情况</th>
        <th data-options="field:'DEALCONDITION',width:150,align:'center'">处理情况</th>
        <th data-options="field:'DEALUSER',width:80,align:'center'">处理人</th>
        <th data-options="field:'DTBACK',width:80,align:'center'">反馈日期</th>
        <th data-options="field:'TESTDEPARTMENT',width:80,align:'center'">检测部门</th>
        <th data-options="field:'VCSTATUS',width:80,align:'center'">状态</th>
        <th data-options="field:'VCTYPE',width:80,align:'center'">类型</th>
    </tr>
    </thead>
</table>
<!-- toolbar -->
<div id="tb" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
        <a href="#" id="edit" class="easyui-linkbutton" iconCls="icon-edit" plain="true">反馈</a>
        <a href="#" id="remove" class="easyui-linkbutton" iconCls="icon-remove" plain="true">移除</a>
        <a href="#" id="detail" class="easyui-linkbutton" iconCls="icon-large-smartart" plain="true">详情</a>
        <a href="/csmis/capacitor/dataExcel.action" id="redo" class="easyui-linkbutton" iconCls="icon-redo" plain="true">导出Excel</a>
        <form name="searchform" method="post" action="" id ="searchform">
            <td width="70" height="30"><strong></strong></td>
            <td height="30">
                线路:
                <select class="easyui-validatebox" style="width:150px" name="searchLine"
                        id="searchLine">
                </select>
                车间:
                <select class="easyui-validatebox" style="width:150px" name="searchWorkshop"
                        id="searchWorkshop" onchange="changeWs('searchWorkshop','searchWorkarea')">
                </select>
                工区:
                <select class="easyui-validatebox" style="width:150px" name="searchWorkarea"
                        id="searchWorkarea" onchange="changeWa('searchWorkarea','searchStation')">
                </select>
                车站:
                <select class="easyui-validatebox" style="width:150px" name="searchStation"
                        id="searchStation">
                </select>
                类型:
                <select class="easyui-combobox" style="width:150px" name="searchVcType"
                        id="vcType">
                    <option value="">全部</option>
                    <option value="0">上行电容</option>
                    <option value="1">下行电容</option>
                </select>
                <a href="#" class="easyui-linkbutton" id="search" plain="true" iconCls="icon-search">搜索</a>
            </td>
        </form>
    </div>
</div>
<div id="win-show" data-options="iconCls:'icon-save'"></div>

<script type="text/javascript">
    $(document).ready(function () {
        /**init data*/
        initLine("searchLine","");
        initChejian("searchWorkshop","");

        /**search data*/
        $('#search').on('click', function () {
            $('#dataTab').datagrid({ queryParams: form2Json("searchform") });
        });

        $('#edit').on('click', function () {
            var row = $('#dataTab').datagrid('getSelected');
            if (row) {
                $('#win-show').dialog({
                    title: '反馈数据',
                    width:700,
                    height:600,
                    closed: false,
                    cache: false,
                    href: '/csmis/capacitor/getBackById.action?id=' + row.NID,
                    modal:true
                });
            }
        });

        $('#remove').on('click', function () {
            var row = $('#dataTab').datagrid('getSelected');
            if (row) {
                $.messager.confirm('提示', '你确认要删除该数据吗？', function (r) {
                    if (r) {
                        $.ajax({
                            url: "/csmis/capacitor/delDataById.action?id=" + row.NID,
                            type: "POST"
                        }).done(function (doc) {
                                $('#dataTab').datagrid('load');
                        });
                    }

                });
            }
        });
        $('#detail').on('click', function () {
            var row = $('#dataTab').datagrid('getSelected');
            if (row) {
                $('#win-show').dialog({
                    title: '数据详情',
                    iconCls: 'icon-large-smartart',
                    width: 670,
                    height: 710,
                    closed: false,
                    cache: false,
                    href: '/csmis/capacitor/getBackById.action?id=' + row.NID +"&show=1",
                    modal: true
                });
            }
        });
    })
    ;
    function getInitData(){
        $('#dataTab').datagrid({queryParams: form2Json("searchform")});
    }
    //将表单数据转为json
    function form2Json(id) {
        var arr = $("#" + id).serializeArray()
        var jsonStr = "";
        jsonStr += '{';
        for (var i = 0; i < arr.length; i++) {
            jsonStr += '"' + arr[i].name + '":"' + arr[i].value + '",'
        }
        jsonStr = jsonStr.substring(0, (jsonStr.length - 1));
        jsonStr += '}'
        var json = JSON.parse(jsonStr)
        return json
    }
</script>
</body>
</html>
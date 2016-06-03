<!DOCTYPE html>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@page isELIgnored="false" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<html lang="zh-CN">
<head>
    <title>安全电容检测数据反馈</title>
    <meta charset="UTF-8">
    <script type="text/javascript" src="/csmis/js/public.js" charset="GBK"></script>
    <script type="text/javascript" src="/csmis/safe/capacitor/opration.js" charset="GBK" async="async"></script>
    <link rel="stylesheet" type="text/css" href="/csmis/js/jquery-easyui-1.4.1/themes/default/easyui.css" charset="gbk">
    <link rel="stylesheet" type="text/css" href="/csmis/js/jquery-easyui-1.4.1/themes/icon.css" charset="gbk">
    <link rel="stylesheet" type="text/css" href="/csmis/js/jquery-easyui-1.4.1/demo/demo.css" charset="gbk">
    <script type="text/javascript" src="/csmis/js/jquery-easyui-1.4.1/jquery.min.js" charset="gbk"></script>
    <script type="text/javascript" src="/csmis/js/jquery-easyui-1.4.1/jquery.easyui.min.js" charset="gbk"></script>
</head>
<!--[if lte IE 9]>
<script type="text/javascript" src="/csmis/newjs/html5.min.js"></script>
<script type="text/javascript" src="/csmis/newjs/respond.min.js"></script>
<![endif]-->
<body style="width: 600px;height: 700px">
<div style="padding:5px 0 5px 5px;background-color: #E2E8EE">
    <table class="easyui-datagrid" data-options="nowrap:false" style="width:100%;height:auto;text-align:center;">
        <thead>
        <tr>
            <th field="name1" width="200" align="center"><strong>基础信息</strong></th>
            <th field="name2" width="400" align="center" nowrap="false"></th>
        </tr>
        </thead>
        <tbody>
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
        </tbody>
    </table>
</div>
<div style="padding:5px 0 5px 5px;background-color: #E2E8EE">
    <table class="easyui-datagrid" data-options="nowrap:false" style="width:100%;height:auto;text-align:center;">
        <thead>
        <tr>
            <th field="name1" width="200" align="center"><strong>反馈信息</strong></th>
            <th field="name2" width="400" align="center"></th>
        </tr>
        </thead>
        <tbody>
        <input type="hidden" value="${map.NId}" name="nId"/>
        <input type="hidden" value="1" name="vcStatus"/>
        <tr>
            <td>更换后电容用量:</td>
            <td>${map.rlAfter}</td>
        </tr>
        <tr>
            <td>更换后电容电压:</td>
            <td>${map.dyAfter}</td>
        </tr>
        <tr>
            <td>更换后电容电流:</td>
            <td>${map.dlAfter}</td>
        </tr>
        <tr>
            <td>更换后厂家:</td>
            <td>${map.factoryAfter}</td>
        </tr>
        <tr>
            <td>检测测试情况:</td>
            <td>${map.factoryAfter}</td>
        </tr>
        <tr>
            <td>处理情况:</td>
            <td>${map.dealCondition}</td>
        </tr>
        <tr>
            <td>处理人:</td>
            <td>${map.dealUser}</td>
        </tr>
        <tr>
            <td>检测部门:</td>
            <td>${map.testDepartment}</td>
        </tr>
        </tbody>
    </table>
</div>
</body>

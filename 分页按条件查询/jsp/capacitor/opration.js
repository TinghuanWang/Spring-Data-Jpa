/**
 capacitor javascrip
 */
/**
 * obj for object
 * val for select value
 * */
function initLine(obj,val) {
    $.ajax({
        url: "/csmis/getAllLines.action",
        type: "post",
        dataType: "json",
        cache: true,
        success: function (data) {
            var line = $("#"+obj+"");
            line.empty();
            line.append("<option value=''>请选择</option>");
            $.each(data, function (index, value) {
                if (val == data[index].opValue) {
                    line.append("<option value='" + data[index].opValue + "' selected>" +
                        data[index].opName +
                        "</option>");
                } else {
                    line.append("<option value='" + data[index].opValue + "'>" +
                        data[index].opName +
                        "</option>");
                }
            });
        }, error: function () {

        }
    });
}
/***
 *obj  for object
 * val for select value
 * */
function initChejian(obj,val) {
    $.ajax({
        url: "/csmis/getAllChejian.action",
        type: "post",
        dataType: "json",
        cache: true,
        success: function (data) {
            var workshop = $('#'+obj+'');
            workshop.empty();
            workshop.append("<option value=''>请选择</option>");
            $.each(data, function (index, value) {
                if (val == data[index].opValue) {
                    workshop.append("<option value='" + data[index].opValue + "' selected>" +
                        data[index].opName +
                        "</option>");
                } else {
                    workshop.append("<option value='" + data[index].opValue + "'>" +
                        data[index].opName +
                        "</option>");
                }

            });
        }, error: function () {
        }
    });

}

function changeWs(self,resp) {
    var vcWorkshop = document.getElementsByName(""+self+"")[0].value;
    var xml = getDynaXmlData("/csmis/dynaxmldataservlet?name=getWorkareaByWs&vcOrgID=" + vcWorkshop);
    try {
        addOption(document.getElementsByName(""+resp+"")[0], xml, "1");
    } catch (e) {
    }
}


function changeWa(self,resp) {
    var vcWorkarea = document.getElementsByName(""+self+"")[0].value;
    var xml = getDynaXmlData("/csmis/dynaxmldataservlet?name=getOrgStaion&vcOrgID=" + vcWorkarea);
    try {
        addOption(document.getElementsByName(""+resp+"")[0], xml, "1");
    } catch (e) {
    }
}
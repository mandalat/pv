function showFirstList(pObj, data) {
    var item, count, index,
        list = $('<div class="per_scroll_box"></div>'),
        pageTemp = $('<div class="per_items_box"></div>'),
        result = $('<div class="per_side"></div>'),
        action = $('<div class="scroll_thumb tc"><em class="s_l"><img src="imgs/personal_home/t_l.png" alt=""/></em><span>N/N</span><em class="s_r"><img src="imgs/personal_home/t_r.png" alt=""/></em></div>'),
        itemView;
    count = 0;
    index = 0;
    for (var key in data) {
        item = data[key];
        if (item.length == 0) continue;
        itemView = listProcess(item, index);
        if (count % 3 == 0) {
            pageTemp = $('<div class="per_items_box"></div>');
            list.append(pageTemp);
            index = 0;
        }
        pageTemp.append(itemView);
        count++;
        index++;
    }
    list.append($('<div class="cl"></div>'));
    pObj.append(result.append(list));
    if (count > 3)
        pObj.append(action);
}
function listProcess(data, index) {
    var first = data[0],
        table, i, count,
        columns = [],
        innerHtml = "",
        temp,
        itemView = $('<div class="personal_items"></div>'),
        tleTemp = $('<div class="personal_items_tit">' + first["fix_title"] + '<span class="more"></span></div>'),//<a href="' + first["fix_morelink"] + '">更多&gt;&gt;</a>
        tblTemp = $('<div class="personal_items_info tc"></div>');
    if (index == 1) itemView.addClass("mtb12");
    table = $('<table cellpadding="0" cellspacing="0"></table>');
    count = 0;
    innerHtml = "<tr>";
    for (var column in first) {
        if (column.substr(0, 4) != "fix_") {
            count++;
            columns.push(column);
            temp = count < 3 ? ("<th>" + column + "</th>") : ("<td>" + column + "</td>");
            innerHtml += temp;
        }
    }
    if (first["fix_title"] != null && first["fix_title"] != "" && first["fix_title"] != undefined) {
        switch (first["fix_title"].replace(/(^\s*)|(\s*$)/g, "")) {
            case "门诊记录":
            case "住院治疗":
                innerHtml += "</tr>";

                for (i = 0; i < data.length; i++) {
                    innerHtml += "<tr>";
                    for (var j = 0; j < columns.length; j++) {
                        if (data[i][columns[j]] != null) {
                            var op_time = data[i][columns[j]].toString();
                            if (op_time.indexOf('T') != -1) {
                                var index = op_time.indexOf('T');
                                var de_time = op_time.substring(0, index);
                                data[i][columns[j]] = de_time;
                            }
                        }
                        temp = j < 2 ? ("<th>" + data[i][columns[j]] + "</th>") : ("<td>" + data[i][columns[j]] + "</td>");
                        innerHtml += temp;
                    }
                    innerHtml += '</tr>';
                }
                table.html(innerHtml);
                tblTemp.append(table);
                itemView.append(tleTemp).append(tblTemp);
                return itemView;
                break;
            case "疾病管理":
                innerHtml += "<td>操作</td></tr>";

                for (i = 0; i < data.length; i++) {
                    innerHtml += "<tr>";
                    for (var j = 0; j < columns.length; j++) {
                        if (data[i][columns[j]] != null) {
                            var op_time = data[i][columns[j]].toString();
                            if (op_time.indexOf('T') != -1) {
                                var index = op_time.indexOf('T');
                                var de_time = op_time.substring(0, index);
                                data[i][columns[j]] = de_time;
                            }
                        }
                        temp = j < 2 ? ("<th>" + data[i][columns[j]] + "</th>") : ("<td>" + data[i][columns[j]] + "</td>");
                        innerHtml += temp;
                    }
                    innerHtml += '<td><a href="upage.ashx?id=' + data[i]['fix_id'] + '&pageid=M8">点击浏览</a></td></tr>';
                }
                table.html(innerHtml);
                tblTemp.append(table);
                itemView.append(tleTemp).append(tblTemp);
                return itemView;
                break;
            case "儿童保健":
                innerHtml += "<td>操作</td></tr>";

                for (i = 0; i < data.length; i++) {
                    innerHtml += "<tr>";
                    for (var j = 0; j < columns.length; j++) {
                        if (data[i][columns[j]] != null) {
                            var op_time = data[i][columns[j]].toString();
                            if (op_time.indexOf('T') != -1) {
                                var index = op_time.indexOf('T');
                                var de_time = op_time.substring(0, index);
                                data[i][columns[j]] = de_time;
                            }
                        }
                        temp = j < 2 ? ("<th>" + data[i][columns[j]] + "</th>") : ("<td>" + data[i][columns[j]] + "</td>");
                        innerHtml += temp;
                    }
                    innerHtml += '<td><a href="upage.ashx?id=' + data[i]['fix_id'] + '&pageid=M4">点击浏览</a></td></tr>';
                }
                table.html(innerHtml);
                tblTemp.append(table);
                itemView.append(tleTemp).append(tblTemp);
                return itemView;
                break;
            case "妇女保健":
                innerHtml += "<td>操作</td></tr>";

                for (i = 0; i < data.length; i++) {
                    innerHtml += "<tr>";
                    for (var j = 0; j < columns.length; j++) {
                        if (data[i][columns[j]] != null) {
                            var op_time = data[i][columns[j]].toString();
                            if (op_time.indexOf('T') != -1) {
                                var index = op_time.indexOf('T');
                                var de_time = op_time.substring(0, index);
                                data[i][columns[j]] = de_time;
                            }
                        }
                        temp = j < 2 ? ("<th>" + data[i][columns[j]] + "</th>") : ("<td>" + data[i][columns[j]] + "</td>");
                        innerHtml += temp;
                    }
                    innerHtml += '<td><a href="upage.ashx?id=' + data[i]['fix_id'] + '&pageid=M5">点击浏览</a></td></tr>';
                }
                table.html(innerHtml);
                tblTemp.append(table);
                itemView.append(tleTemp).append(tblTemp);
                return itemView;
                break;
            case "体检记录":
                innerHtml += "<td>操作</td></tr>";

                for (i = 0; i < data.length; i++) {
                    innerHtml += "<tr>";
                    for (var j = 0; j < columns.length; j++) {
                        if (data[i][columns[j]] != null) {
                            var op_time = data[i][columns[j]].toString();
                            if (op_time.indexOf('T') != -1) {
                                var index = op_time.indexOf('T');
                                var de_time = op_time.substring(0, index);
                                data[i][columns[j]] = de_time;
                            }
                        }
                        temp = j < 2 ? ("<th>" + data[i][columns[j]] + "</th>") : ("<td>" + data[i][columns[j]] + "</td>");
                        innerHtml += temp;
                    }
                    innerHtml += '<td><a href="upage.ashx?id=' + data[i]['fix_id'] + '&pageid=M11&foucs=' + data[i]['住院号'] + '">点击浏览</a></td></tr>';
                }
                table.html(innerHtml);
                tblTemp.append(table);
                itemView.append(tleTemp).append(tblTemp);
                return itemView;
                break;
            case "检验结果":
                innerHtml += "<td>操作</td></tr>";

                for (i = 0; i < data.length; i++) {
                    innerHtml += "<tr>";
                    for (var j = 0; j < columns.length; j++) {
                        if (data[i][columns[j]] != null) {
                            var op_time = data[i][columns[j]].toString();
                            if (op_time.indexOf('T') != -1) {
                                var index = op_time.indexOf('T');
                                var de_time = op_time.substring(0, index);
                                data[i][columns[j]] = de_time;
                            }
                        }
                        temp = j < 2 ? ("<th title='" + data[i][columns[j]] + "'>" + CutString(data[i][columns[j]], 7) + "</th>") : ("<td>" + data[i][columns[j]] + "</td>");
                        innerHtml += temp;
                    }
                    innerHtml += '<td><a href="upage.ashx?id=' + data[i]['fix_id'] + '&pageid=M12&foucs=' + data[i]['fix_xh'] + '" target="_blank">点击浏览</a></td></tr>';
                }
                table.html(innerHtml);
                tblTemp.append(table);
                itemView.append(tleTemp).append(tblTemp);
                return itemView;
                break;

            default:
                break;
        }
    }
}



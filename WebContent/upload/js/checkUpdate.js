 function checkUpdate() {
			if (document.getElementById("评估人")!=null && (document.getElementById("评估人").disabled == true || document.getElementById("评估人").readOnly == true))
                return true;

			if (document.getElementById("是否脑出血")!=null && document.getElementById("是否脑出血").checked == false) {
                return true;
            }

            var message = ""
            var radioArray = new Array();
            var arrAll = document.getElementsByTagName("input");
            var tempItemName = "";

			var curLevel = ""
			if(document.getElementById("curLevel") != null)
				curLevel = document.getElementById("curLevel").value;

            for (i = 0; i < arrAll.length; i++) {
                var tempobj = arrAll[i];
                if (tempobj.type.toLowerCase() == "text" && (tempobj.name.indexOf(curLevel) > -1 || tempobj.name.indexOf("评估人") > -1) && tempobj.value == "" && tempobj.readOnly == false &&  tempobj.disabled == false) {
                    message = message + "\n" + tempobj.name + "为必填项";
                }
                else if (tempobj.type.toLowerCase() == "radio" && tempobj.disabled == false && tempobj.readOnly == false && tempobj.name != tempItemName) {
                    radioArray.push(tempobj.name);
                }
                else if (tempobj.type.toLowerCase() == "checkbox" && tempobj.disabled == false && tempobj.readOnly == false && tempobj.name != tempItemName) {
                    radioArray.push(tempobj.name);
                }
                tempItemName = tempobj.name;
            }

            var isChecked = false;
            for (i = 0; i < radioArray.length; i++) {
                isChecked = false;
                var arrRadio = document.getElementsByName(radioArray[i]);
                for (k = 0; k < arrRadio.length; k++) {
                    if (arrRadio[k].checked) {
                        isChecked = true;
                    }
                }
                if (isChecked == false) {
                    message = message + "\n" + radioArray[i] + "为必填项";
                }
            }

            if (message == "")
                return true;
            else {
				message = "相应内容确实为空的，请填写'NA' \n \n" + message;
                alert(message);
                return false;
            }
        }
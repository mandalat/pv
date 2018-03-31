 
	// 上传图片
	/*
	*	upload_type : 1(默认图片)，2（音乐）
	*/
	function initFileUpload($fileUpload, sucCallback, upload_type){
		// 上传文件类型
		upload_type = upload_type ? upload_type : 1;

		$fileUpload.fileupload({
			dataType: 'json',
			progressall: function (e, data) {
				var $cont = $(this).closest(".cover-area");
				var progress = parseInt(data.loaded / data.total * 100, 10);
				var $progress = $cont.find(".fileupload-process");
				if ($progress.size() == 0) {
					$progress = $("<div class='fileupload-process progress-animated'><div class='bar' style='width: 0%;''></div></div>").appendTo($cont);
				}
				$progress.find(".bar").css(
						'width',
						progress + '%'
				);
			},
			change: function (e, data) {

				var flag = true;
				var $cont = $(this).closest(".cover-area");
				$.each(data.files, function (index, file) {
					var fileName = file.name;
					var fileSize = file.size;
					var $fileInput = $(data.fileInputClone[index]);
					var extStart = fileName.lastIndexOf(".");
					var ext = fileName.substring(extStart, fileName.length).toUpperCase();
					if( upload_type == 1 ){
						if (ext != ".BMP" && ext != ".PNG" && ext != ".GIF" && ext != ".JPG" && ext != ".JPEG") {
							alert("图片限于bmp,png,gif,jpeg,jpg格式");
							flag = false;
							return false;
						}
					}else if( upload_type == 2 ){
						console.log(ext)
						if (ext != ".MP3" && ext != ".OGG" && ext != ".WAV") {
							alert("音乐限于mp3,ogg,wav格式");
							flag = false;
							return false;
						}
					}
					else if( upload_type == 3 ){
						console.log(ext)
						if (ext != ".HTML" && ext != ".HTM") {
							alert("网页限于html,htm格式");
							flag = false;
							return false;
						}
					}
					
					var sizeLimit = 200;
					if ($fileInput.data("sizelimit")) {
						sizeLimit = $fileInput.data("sizelimit");
					}
					if (fileSize > sizeLimit * 1024) {
						if( upload_type == 1 ){
							alert("图片大小不能超过" + sizeLimit + "KB");
						}else if( upload_type == 2 ){
							alert("音乐大小不能超过" + sizeLimit + "KB");
						}else if( upload_type == 3 ){
							alert("网页大小不能超过" + sizeLimit + "KB");
						}
						
						flag = false;
						return false;
					}
				});
				if (!flag) {
					return false;
				}
			},
			done: function (e, data) {
				console.log(data);
				var result = data._response.result._response.result;
				console.log(result);
				var $cont = $(this).closest(".cover-area");
				var $progress = $cont.find(".fileupload-process");
				if (result.error == "filetype" && upload_type == 1 ) {
					
					alert("只能上传图片格式：" + result.allowtype);
					$progress.remove();
					return false;
				}
									
				var $fileInput = $cont.find(".fileupload_input");
				
				// 加载页面图片编辑特殊处理
				if( upload_type == 1 ){
					// 图片
					if($fileInput.attr("data-target")){
						 $$($fileInput.attr("data-target")).css("background-image","url("+result.fileUrl+")");
					}
					console.log(result.fileUrl);
					$cont.find(".thumb_img").attr("src", result.fileUrl);
				}else if( upload_type == 2 ){
					// 音乐
					$cont.find(".music_name").html( result.fileUrl );
					$cont.find(".music_cover-recovery").show();
					$cont.find(".upload_music_1_1").val(result.fileUrl )
				}
				
				$cont.find(".huifuBtn").show();
				
				$cont.find(".cover-del").show();
				$cont.find(".upload_text").hide();
				$progress.remove();
				$fileInput.val(result.fileUrl); 
					 
				sucCallback && sucCallback(data, $cont);
			}
		});
	}

		$(function () {
		$("input[name='fileupload']").each(function (index, item) {
			var $fileUpload = $(item);
  
					initFileUpload($fileUpload , function(data , $cont){
						window.uploadFileCallback && window.uploadFileCallback.call(this , data , $cont);
					},3);
	  
		});
	}); 

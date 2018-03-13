var bandTelNO = 0;
var params = $.deparam(window.location.search.substring(1));
$(function() {
	$("#signin-btn2").click(
			function(d) {
				d.stopPropagation();
				var c = $(this);
				if (c.hasClass("loading")) {
					return false
				}
				var e = $("#patname");
				var a = $("#visitno");
				if (!e.val()) {
					alert("请输入您的姓名！");
					return false
				}
				if (!a.val()) {
					alert("请输入您的住院号！");
					return false
				}
				var b = {
					patname : e.val(),
					visitno : a.val()
				};
				c.addClass("loading").text("登录中...");
				$.post(serverroot + "/system/checkPatientLogin", b, function(f) {
					if (f.success == true) {
						$.cookie("patname", e.val(), {
							expires : 14,
							path : "/"
						});
						window.location.href = serverroot
								+ "/system/patientLogin.html"
					} else {
						if (f.ret == -19) {
							$(".login-tel-success").hide();
							$(".login-tel-yanzheng").show();
							$.ajax({
								url : "/getBindTel",
								type : "GET",
								data : {
									patname : e.val()
								},
								dataType : "json",
								success : function(g) {
									bandTelNO = g.model.bindTel;
									var h = bandTelNO.substring(0, 4) + "****"
											+ bandTelNO.substring(7, 12);
									$(".bandTel").text(h)
								},
								error : function() {
									alert("服务器繁忙！")
								}
							})
						} else {
							c.removeClass("loading").text("登 录");
							alert(f.msg)
						}
					}
				}, "json");
				return false
			});
	$("#signin-btn-yanzheng")
			.on(
					"click",
					function() {
						var b = $(this);
						if (b.hasClass("loading")) {
							return false
						}
						var a = {
							patname : $("#patname").val(),
							visitno : $("#visitno").val(),
							verify : $.trim($(".input_tel_code").val())
						};
						b.addClass("loading").text("登录中...");
						$
								.post(
										"/login",
										a,
										function(c) {
											if (c.ret == 0) {
												$.cookie("patname", $(
														"#patname")
														.val(), {
													expires : 14,
													path : "/"
												});
												if (window.location.host == "bar.weijuju.com") {
													window.location.href = "/admin/screen_bar/main.jsp";
													return
												}
												if (window.location.host == "screen.weijuju.com"
														|| params.type == "screen") {
													window.location.href = "/admin/meeting/main.jsp";
													return
												}
												if (window.location.hash == "#jifenbao") {
													window.location.href = "/market/continuousLand.jsp#logged";
													return
												}
												if (window.location.hash == "#hb") {
													window.location.href = "/admin/hb/main.jsp";
													return
												}
												window.location.href = c.model.url
											} else {
												b.removeClass("loading").text(
														"登 录");
												alert(c.msg)
											}
										}, "json")
					});
	if ($.cookie("patname")) {
		$("#patname").val($.cookie("patname"))
	}
	if ($("#patname").val() == "") {
		$("#patname").focus()
	} else {
		$("#signin-password").focus()
	}
	$(".confirmtips").bind("click", function() {
		$("#cover").fadeOut();
		$(".showPswTips").fadeOut();
		$(".showCodeTips").fadeOut()
	});
	$(".loginforgetpsw").bind("click", function() {
		$("#cover").fadeIn();
		$(".showPswTips").fadeIn()
	});
	$(".loginnottelcode").bind("click", function() {
		$("#cover").fadeIn();
		$(".showCodeTips").fadeIn()
	});
	$(".login_tab li").on("click", function() {
		$(".login_tab li.active").removeClass("active");
		var a = $(this).addClass("active");
		if ($(this).index() == 0) {
			$(".code_login").show();
			$(".login-tel-success").hide();
			$(".login-tel-yanzheng").hide()
		} else {
			$(".code_login").hide();
			$(".login-tel-success").show();
			$(".login-tel-yanzheng").hide()
		}
	});
	$("#remember-check").bind("change", function() {
		var a = $(this);
		var b = a.is(":checked");
		if (b) {
			a.next().addClass("ui-state-active")
		} else {
			a.next().removeClass("ui-state-active")
		}
	})
});
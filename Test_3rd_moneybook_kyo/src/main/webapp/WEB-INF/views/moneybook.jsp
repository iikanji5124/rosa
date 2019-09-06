<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일일 가계부</title>
<script src='<c:url value="/js/jquery-3.4.1.js" />'></script>
<script>
	var Infonum = "";
	$(function () {
		show();
		clear();
		$("#isertList").on("click",Listinsert);
		$("#deleteList").on("click",Listdelete);
		$("#inputdate").on("change",searchDate);
	});
	function clear() {
		$("#memo").val("");
		$("#amount").val("");
	}
	
	function InfonumSave(num) {
		Infonum = num;
	}
	
	function show() {
		$("#list").html("");
		var str = "";
		
		str+="<tr>";
		str+="<td colspan='2'>메모</td>";
		str+="<td colspan='2'>금액</td>";
		str+="</tr>";
		
		$("#list").append(str);
	}
	
	function searchDate() {
		var Type = $("#type").val();
		var Inputdate = $("#inputdate").val();
		
		$.ajax({
			url:"searchDate",
			type:"post",
			data:{
				type : Type,
				inputdate : Inputdate
			},
			success:function(result){
				Flag = "false";
				$("#list").html("");
				var str = '';
				str+="<tr>";
				str+="<td colspan='2'>메모</td>";
				str+="<td colspan='2'>금액</td>";
				str+="<td>삭제</td>";
				str+="</tr>";
			
				for (var i = 0; i < result.length; i++) {
					str+='<tr>';
					str+='<td colspan="2">'+result[i].memo+'</td>';
					str+='<td colspan="2">'+result[i].amount+'</td>';
					str+='<td><input type="radio" id="del" onclick="InfonumSave('+result[i].infonum+')" data-infonum='+result[i].infonum+'></td>';
					str+='</tr>';
				}
				clear();
				$("#list").append(str);
			},
			error:function(){
				alert("부분 검색 실패");
			}
		});
	}
	
	function Listdelete() {
		if(Infonum == ''){
			alert("삭제할 항목을 선택해주세요.");
		}
		$.ajax({
			url:"deleteList",
			type:"post",
			data:{
				infonum : Infonum
			},
			success:function(result){
				if(result == "true"){
					searchDate();
					clear();
					Infonum="";
				}
			},
			error:function(){
				
			}
		});
	}
	
	function Listinsert() {
		var Type = $("#type").val();
		var Date = $("#inputdate").val();
		var Memo = $("#memo").val();
		var Amount = $("#amount").val();
		if(Date == ''){
			alert("날짜를 입력하세요!");
			return;
		}
		if(Memo == ''){
			alert("메모를 입력하세요.");
			return;
		}
		if(Amount == ''){
			alert("금액를 입력하세요.");
			return;
		}
		
		if(isNaN(Amount)){
			alert("숫자를 입력하세요!");
			return;
		}
		
		$.ajax({
			url:"insertList",
			type:"post",
			data:{
				type : Type,
				inputdate : Date,
				memo : Memo,
				amount : Amount
			},
			success:function(result){
				if(result == "true"){
					searchDate();
					clear();
				}
			},
			error:function(){
				
			}
		});
	}
</script>
</head>
<body>
	<table>
		<tr>
			<td>
				<select id="type">
					<option value="수입" selected>수입</option>
					<option value="지출">지출</option>
				</select>
			</td>
			<td>
				<input type="date" id="inputdate">
			</td>
		</tr>
		<tr>
			<td>
				<td colspan="2">
				메모
			</td>
			<td colspan="2">
				금액
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="text"	id="memo" name="memo" placeholder="내용 입력">
			</td>
			<td colspan="2">
				<input type="text"	id="amount" name="amount" placeholder="금액 입력">
			</td>
			<td>
				<input type="button" value="등록" id="isertList">
			</td>
			<td>
				<input type="button" value="삭제" id="deleteList">
			</td>
		</tr>
		
	</table>
	<table id="list">

	</table>
</body>
</html>

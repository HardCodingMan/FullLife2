<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약하기</title>
<link rel="stylesheet" type="text/css" href="/css/reservation.css">

</head>
<body>
<script>
window.onload = function() {
    var regionTag = document.querySelector("#region");
    var result = "";

    regionTag.addEventListener("change",function(){
        result = regionTag.value;
        location.href="/reserve/select?location1="+result;
		console.log(result);
    });
}
</script>
	<header>
    	<jsp:include page="/HeaderNFooterJSP/Header.jsp"></jsp:include>
    </header>
    <main>
        <div id="main-navi">
            <h2>예약하기</h2>
        </div>
        <div id="organSelect">
            <h4><u>장기선택(중복가능)</u></h4>
            <table id="organTable">
                <tr>
                    <td><img src="../img/organTrans/liver.png" class="btn-organ"></td>
                    <td><img src="../img/organTrans/heart.png" class="btn-organ"></td>
                    <td><img src="../img/organTrans/tooth.png" class="btn-organ"></td>
                    <td><img src="../img/organTrans/bone.png" class="btn-organ"></td>
                    <td><img src="../img/organTrans/lung.png" class="btn-organ"></td>
                </tr>
                <tr>
                    <td>폐</td>
                    <td>심장</td>
                    <td>치아</td>
                    <td>뼈</td>
                    <td>간</td>
                </tr>
                <tr>
                    <td>
                        <select>
                            <option value="1">1</option>
                            <option value="2">2</option>
                        </select>
                    </td>
                    <td></td>
                    <td>
                        <select>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                        </select>
                    </td><td>
                        <select>
                            <option value="1">1</option>
                            <option value="2">2</option>
                        </select>
                    </td><td>
                        <select>
                            <option value="1">1</option>
                            <option value="2">2</option>
                        </select>
                    </td>
                </tr>
            </table>
        </div>
        <br>
        <hr>
        <div id="findHos">
            <h4><u>병원선택</u></h4>
            <div id="findArea">
                <tr>
                    <td>
                        <select id="region">
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                        	<option value="" selected>----- 병원 선택 ------</option>
=======
>>>>>>> origin/Hyunseok
=======
>>>>>>> 5c3b789bfc223a181bc4cdbbe572cac4e2184544
=======
>>>>>>> origin/Hyunseok
                            <option value="seoul"<c:if test="${metroCity eq  'seoul'}">selected</c:if>>서울
                            <option value="daejeon"<c:if test="${metroCity eq 'daejeon' }">selected</c:if>>대전</option>
                            <option value="daegu" <c:if test="${metroCity eq 'daegu' }">selected</c:if>>대구</option>
                            <option value="busan" <c:if test="${metroCity eq 'busan' }">selected</c:if>>부산</option>
                            <option value="gwangju"<c:if test="${metroCity eq 'gwangju' }">selected</c:if>>광주</option>
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<!--                         	<option value="" selected>----- 병원 선택 ------</option> -->
<!--                             <option value="seoul">서울</option> -->
<!--                             <option value="daejeon">대전</option> -->
<!--                             <option value="daegu">대구</option> -->
<!--                             <option value="busan">부산</option> -->
<!--                             <option value="gwangju">광주</option> -->
=======
>>>>>>> origin/Hyunseok
=======
=======
                        	<option value="" selected>----- 병원 선택 ------</option>
                            <option value="seoul">서울</option>
                            <option value="daejeon">대전</option>
                            <option value="daegu">대구</option>
                            <option value="busan">부산</option>
                            <option value="gwangju">광주</option>
>>>>>>> e656fdeda676b8b971d3033e5531efe878fb775c
>>>>>>> 5c3b789bfc223a181bc4cdbbe572cac4e2184544
=======
>>>>>>> origin/Hyunseok
                        </select>
                    </td>           
                </tr>
            </div>
            <br>
            <div id="hosDetail">
                <div id="viewHos">
                    <h4>병원명</h4>
<<<<<<< HEAD
    				<div id="result">
    				<c:forEach items="${requestScope.hospitals }" var="hospital" varStatus="index" >
    				<label><input type="radio" id="hospital-name" name="chosen-hospital"><b style="font-size:25px">${hospital.hospitalName }</b>
                		<h4 style="margin:10px">${hospital.hospitalAddr }</h4></label>  <button onclick=>위치보기</button>

    				<c:forEach items="${requestScope.hospitals}" var="hospital" varStatus="index" >
    				<label><input type="radio" id="hospital-name" name="chosen-hospital"><b style="font-size:25px">${hospital.hospitalName }</b>
                		<h4 style="margin:10px">${hospital.hospitalAddr }</h4></label>  <button onclick="selectHospital(${hospital.hospitalAddr}})">위치보기</button>

           			 </c:forEach>
           			 </div>
                </div>
                <div id="dateTime">
                	<div id="map" style="width:500px;height:400px;">
                	<h4>지도</h4>
					<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=977b62db984a36094fb13c99f6a75050&libraries=services"></script>
					<script>
				            var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
				            mapOption = {
				                center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
				                level: 3 
				            };  
				            
				            var map = new kakao.maps.Map(mapContainer, mapOption); 
				            var geocoder = new kakao.maps.services.Geocoder();
				            geocoder.addressSearch('서울 서초구 반포대로 222', function (result, status) {
				                if (status === kakao.maps.services.Status.OK) {
				                    var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
				                    
				                    var marker = new kakao.maps.Marker({
				                        map: map,
				                        position: coords
				                    });
				                    var infowindow = new kakao.maps.InfoWindow({
				                        content: '<div style="width:150px;text-align:center;padding:6px 0;">서울성모병원</div>'
				                    });
				                    infowindow.open(map, marker);
				                    map.setCenter(coords);
				                } 
				            });    
		            </script>
		            </div>         
=======
                <div id="result">
                <c:forEach items="${requestScope.hospitals}" var="hospital" varStatus="index" >
                <label><input type="radio" id="hospital-name" name="chosen-hospital" hidden><b style="font-size:25px">${hospital.hospitalName }</b>
                      <h4 style="margin:10px">${hospital.hospitalAddr }</h4></label>  <button onclick="selectHospital(${hospital.hospitalAddr}})">위치보기</button>
                     </c:forEach>
                     </div>
                </div>
                <div id="dateTime">
                   <div id="map" style="width:500px;height:400px;">
                   <h4>지도</h4>
               <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=977b62db984a36094fb13c99f6a75050&libraries=services"></script>
               <script>
                        var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
                        mapOption = {
                            center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
                            level: 3 
                        };  
                        
                        var map = new kakao.maps.Map(mapContainer, mapOption); 
                        var geocoder = new kakao.maps.services.Geocoder();
                        geocoder.addressSearch('서울 서초구 반포대로 222', function(result, status) {
                            if (status === kakao.maps.services.Status.OK) {
                                var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
                                
                                var marker = new kakao.maps.Marker({
                                    map: map,
                                    position: coords
                                });
                                var infowindow = new kakao.maps.InfoWindow({
                                    content: '<div style="width:150px;text-align:center;padding:6px 0;">서울성모병원</div>'
                                });
                                infowindow.open(map, marker);
                                map.setCenter(coords);
                            } 
                        });    
                  </script>
                  </div>         
>>>>>>> origin/Hyunseok
                    <div id="selectTime">
                        <h4>시간</h4>
                        <div id="timeBtns">
                            <input type="button" value="09:00" class="btn-time">
                            <input type="button" value="10:00" class="btn-time">
                            <input type="button" value="11:00" class="btn-time">
                            <input type="button" value="12:00" class="btn-time">
                            <input type="button" value="13:00" class="btn-time"><br>
                            <input type="button" value="14:00" class="btn-time">
                            <input type="button" value="15:00" class="btn-time">
                            <input type="button" value="16:00" class="btn-time">
                            <input type="button" value="17:00" class="btn-time">
                            <input type="button" value="18:00" class="btn-time">
                        </div> 
                    </div>
                </div>
            </div>
        </div>    
        <br>
        <hr>
        <div id="info">
            <div id="buyerInfo">
                <h4><u>예약자정보</u></h4>
                <form>
                    <label>
                        <span>이름</span><input type="text" name="userName" id="userName" class="input1" placeholder="이름을 입력해주세요">
                    </label><br>
                    <label>
                        <span>주민등록번호</span><input type="text" name="zumin" id="zumin" class="input1"  placeholder="-을 제외한 13자리를 입력해주세요">
                    </label><br>
                    <label>
                        <span>전화번호</span><input type="text" name="phone" id="phone" class="input1"  placeholder="-을 제외한 11자리를 입력해주세요">
                    </label><br>
                    <label>
                        <span>주소</span><input type="text" name="addr" id="addr" class="input1">
                    </label><br>
                    <label><input type="checkbox" name="check-agree" id="check-agree" checked> 구매자와 이식 받는자가 같습니다.</label>
                </form>
            </div>
            <br>
            <br>
            <div id="realInfo">
            <h4><u>환자정보</u></h4>
            <form>
                <label>
                    <span>이름</span> <input type="text" name="userName" id="userName" class="input1"  placeholder="이름을 입력해주세요">
                </label><br>
                <label>
                    <span>주민등록번호</span> <input type="text" name="zumin" id="zumin" class="input1"  placeholder="-을 제외한 13자리를 입력해주세요">
                </label><br>
                <label>
                    <span>전화번호</span> <input type="text" name="phone" id="phone" class="input1"  placeholder="-을 제외한 11자리를 입력해주세요">
                </label><br>
                <label>
                    <span>주소</span> <input type="text" name="addr" id="addr" class="input1" >
                </label><br>
                <div id="relation"> 
                    <span>환자와의 관계</span>&nbsp;&nbsp;&nbsp; <label>부모<input type="checkbox" name="" id="parent"> 자녀<input type="checkbox" name="" id="child"></label><br>
                </div>
            </form>
            </div>
        </div>
        <br>
        <hr>
        <div id="agree">
            <div id="agree-first">
                <h4>이용약관</h4>
                <textarea name="" id="" cols="175" rows="20">
                    제1장 총칙

                    제1조 목적
                    이 약관은 FullLife(이하 "바이오기술센터"이라 한다)에서 운영하는 인터넷 홈페이지의 서비스(이하 "서비스"라 한다)를
                    이용함에 있어 사이트와 이용자의 권리 의무 및 책임사항을 규정함을 목적으로 합니다.
                    
                    제2조 용어정의
                    이 약관에서 사용하는 용어의 정의는 다음과 같습니다.
                    
                    (1)"사이트"라 함은 병원이 컴퓨터 등 정보통신 설비를 이용하여 제공할 수 있도록 설정한 가상의 공간을 말합니다.
                    (2)"서비스"라 함은 바이오기술센터의홈페이지 및 바이오기술센터가 운영하는 인터넷사이트 등에서 제공하는 인터넷상의 모든 서비스를
                    말합니다.
                    (3)"회원(이용자)"이라 함은 본 약관에 동의하고, 인터넷 홈페이지에 로그인하여 본 약관에 따라 바이오기술센터가 제공하는
                    서비스를 받는 자를 말합니다.
                    (4)"관리자"라 함은 서비스의 전반적인 관리와 원활한 운영을 위하여 병원에서 선정한 사람을 말합니다.
                    (5)"ID"라 함은 회원이 서비스에 제공받기 위하여 본 사이트로 접속할 수 있는 Login 명을 의미하며 한글, 영문과 숫자의
                    조합으로 6자에서 15자 사이로 하고 한글은 3글자에서 8글자 사이로 합니다.
                    (6)"비밀번호"라 함은 회원의 비밀보호 및 회원 본인임을 확인하고 서비스에 제공되는 각종 정보의 보안을 위해 회원
                    자신이 설정하며 회사가 승인하는 영문소문자, 대문자, 숫자의 혼합 등으로 9자에서 16자 사이로 표기한 암호문자를 말합니다.
                    (7)"개인정보"라 함은 당해 정보에 포함되어 있는 성명, 연락처, 주민등록번호 등의 사항에 의하여 특정 개인을 식별할 수 있는 정보를 말합니다.
                    (8)회원은 웹회원, 진료회원, 직원/동문회원, 운영자로 구분되며, 각 회원은 다음과 같은 권한을 가지고 있습니다.
                    - 웹회원
                    바이오기술센터홈페이지를 통해 가입한 회원으로 인터넷에서 제공하는 개인 의료 정보 서비스를 사용하지 않는 회원을 의미 합니다.
                    
                    - 진료회원
                    바이오기술센터 홈페이지를 통해 가입을 하고 발급된 환자번호를 통해 수진이력조회, 입원내역 조회, 진료예약 서비스, 검사결과발급 서비스 등의 다양한 인터넷 의료정보 서비스를 이용할 수 있습니다. 단, 협력병원의 정책에 의해 공개 또는 조회가 제한되는 내역이 있을 수 있습니다.
                    
                    - 관리자
                    본원 인터넷 홈페이지를 관리하기 위하여 최고운영자에 의해 발급된 아이디이며, 각 운영자에게 할당된 권한의 범위에서 홈페이지를 운영/ 관리 할 수 있습니다.
                    
                    (9)회원의 개인정보 보호를 위해 주민등록번호는 복호화가 불가능 한 형태로 암호화 되어 저장되며, 개인 인증 및 의료서비스 연동 등의 불가피한 사항을 제외하고 절대 사용되지 않습니다.
                    제3조 약관의 게시 및 변경
                    (1)이 약관은 병원이 서비스 화면에 공지하거나 기타의 방법으로 회원에게 통보함으로써 그 효력이 발생합니다.
                    (2)병원은 불가피한 사정이 있는 경우 관계법령을 위배하지 않는 범위에서 본 약관을 개정할 수 있습니다.
                    (3)바이오기술센터는 사정상 변경의 경우와 영업상 중요사유가 발생한 경우에는 이 약관을 변경할 수 있으며, 변경된 약관은 전항과 같은 방법으로 공지 또는 통보함으로써 효력을 발생합니다.
                    (4)이 약관에서 정하지 아니한 사항과 이 약관의 해석에 관하여는 관계법령 또는 상관례에 따릅니다.
                    제4조 서비스의 내용 및 변경
                    (1)바이오기술센터는 다음의 서비스를 제공합니다.
                    a.바이오기술센터에서 제공하는 일반 안내 서비스
                    b.진료예약 관련 서비스
                    c.협력병원에서 제공하는 각종 증명서 발급 서비스
                    d.개인건강기록서비스 (SNUH myCare) (2016.12.19. 시행)
                    e.기타 병원이 정하는 서비스
                    (2)바이오기술센터는 불가피한 사정이 있는 경우 제공하는 서비스의 내용을 변경할 수 있으며, 이 경우 변경된 서비스의 내용 및 제공일자를 명시하여 서비스 화면에 공지하거나 기타의 방법으로 회원에게 통보합니다.
                    (3)바이오기술센터는 서비스 내용의 변경으로 인하여 이용자가 입은 손해에 대하여 배상하지 아니합니다. 단, 병원의 고의 또는 중과실이 있는 경우에는 그러하지 아니합니다.
                    제5조 서비스의 중단
                    (1)바이오기술센터는 시스템 등 장치의 보수점검 및 고장, 일시적 통신장애, 서비스 개발, 시스템 정기 점검, 긴급조치 등 불가피한 사유에 의해 서비스 제공이 일정기간 동안 제한 또는 중단될 수 있습니다.
                    (2)바이오기술센터는 제1항의 사유로 서비스 제공이 일시적으로 중단됨으로 인하여 이용자 또는 제3자 가입은 손해에 대하여는 배상하지 아니합니다. 단, 바이오기술센터의 고의 또는 중과실이 있는 경우에는 그러하지 아니합니다.
                    제2장 회원의 가입 및 탈퇴
                    제6조 회원 가입
                    (1)이용자는 바이오기술센터가 정한 양식에 따라 회원정보를 기입한 후 본 약관에 동의한다는 의사표시를 함으로써 회원가입을 신청합니다
                    (2)바이오기술센터는 전 항과 같이 회원으로 가입할 것을 신청한 이용자 중 이하 각호에 해당하지 않는 한 회원으로 등록합니다.
                    a.다른 사람의 명의를 사용하여 신청한 경우
                    b.가입신청자가 본 약관 제7조 2항 또는 3항에 의거하여 이전에 회원 자격을 상실한 적이 있는 경우
                    c.가입신청서의 내용에 허위, 기재누락, 오기가 있는 경우
                    d.기타 회원으로 등록하는 것이 병원의 업무 수행상 현저히 지장이 있다고 판단되는 경우
                    (3)회원가입계약의 성립시기는 병원이 승낙한 시점으로 합니다.
                    (4)회원은 본인의 신상관련 사항이 변경되었을 때는 인터넷을 통하여 수정하는 경우는 이하 각호의 방법을 이용합니다.
                    a.홈페이지 로그인 후 회원정보수정에서 수정합니다.
                    b.회원인 경우는 홈페이지의 회원정보 변경 후 마이페이지 회원정보연동서비스를 통해서 병원의 환자정보 변경을 신청하여야 합니다.
                    제7조 회원 탈퇴 및 자격의 상실
                    (1)회원은 바이오기술센터에 언제든지 탈퇴를 요청할 수 있으며 병원은 즉시 회원탈퇴를 처리합니다. 단, 탈퇴의 요청은 인터넷으로 하여야 하며 개인정보 보호를 위해 개인 확인 절차를 거친 후 탈퇴하게 됩니다. 탈퇴 후 아이디를 제외한 모든 정보는 삭제되며 구매회원의 경우 본원의 환자 관련 정보는 삭제되지 않고 저장 됩니다.
                    (2)회원이 다음 각호의 사유에 해당하는 경우, 바이오기술센터는 회원자격을 상실시킬 수 있습니다.
                    a.회원정보에 허위 내용을 기입한 경우
                    b.다른 사람의 서비스 이용을 방해하거나 그 정보를 도용하는 등 질서를 위협하는 경우
                    c.서비스를 이용하여 얻은 정보를 회원의 개인적인 이용 외에 병원의 허락없이 제3자에게 제공한 경우
                    d.바이오기술센터 내에 제공되는 정보를 변경하는 등 홈페이지 운영을 방해한 경우
                    e.기타 회원으로서의 자격을 지속시키는 것이 부적절하다고 판단되는 경우
                    (3)바이오기술센터 인터넷 사이트를 통하여 진료예약을 한 후 정당한 사유 없이 2회 이상 임의로 진료예약을 포기한 경우 인터넷 진료예약서비스에 대한 자격을 최대 2년간 제한 할 수 있습니다.
                    제8조 회원의 재가입
                    (1)본 약관 제7조의 규정에 따라 회원을 탈퇴한 전 회원이 재가입을 원할 경우 본 약관 제6조에 따라 회원가입을 하면 됩니다.
                    (2)재가입할 경우 본 약관 제7조 3항에 의거하여 발생된 인터넷 진료예약서비스의 미 진료 건수는 전 회원 당시의 내용이 계속 유지됩니다.
                    제3장 개인정보의 보호
                    제9조 개인정보의 수집
                    (1)바이오기술센터는 본 서비스의 원활한 활용을 위해 필요한 이용자의 신상정보를 수집할 수 있습니다.
                    (2)이용자의 개인정보를 수집하는 때에는 이하 각호의 경우를 제외하고는 당해 이용자의 동의를 받습니다.
                    a.법률에 특별한 규정이 있는 경우
                    b.서비스이용계약의 이행을 위해서 필요한 경우
                    (3)바이오기술센터는 개인정보의 분실, 도난, 유출, 변조되지 아니하도록 안정성 확보에 필요한 기술적 조치 등을 강구해야 합니다.
                    (4)제공된 개인정보는 당해 이용자의 동의없이 목적외 이용이나 제3자에게 제공할 수 없습니다. 단, 다음의 경우에는 예외로 합니다.
                    a.법률에 특별한 규정이 있는 경우
                    b.사용자 인증 절차
                    c.서비스의 제공에 따른 요금정산 및 배송등을 위하여 필요한 경우
                    d.바이오기술센터 홈페이지의 원활한 운영 및 통계분석자료로 활용
                    e.통계작성ᆞ학술연구 또는 시장조사를 위하여 필요한 경우로서 특정 개인을 식별할 수 없는 형태로 제공하는 경우
                    제4장 인터넷 진료예약 서비스에 관한 책임의 제한
                    제10조 진료예약의 신청 및 성립
                    (1)이용자는 홈페이지상에서 이하의 방법에 의하여 진료예약을 신청합니다.
                    a.아이디, 비밀번호, 성명, 주소, 전화번호 등 예약시 필요사항 입력
                    b.협력병원, 진료과/센터, 의사명, 예약일시 선택
                    c.이 약관에 동의한다는 표시
                    d.선택 진료인 경우 이에 대한 동의한다는 표시
                    (2)바이오기술센터 제1항의 예약신청에 대하여 다음 각 호의 사유에 해당하지 않는 한 승낙합니다.
                    a.신청 내용에 허위, 기재누락, 오기가 있는 경우
                    b.기타 예약신청에 승낙하는 것이 기술상 현저히 지장이 있다고 판단하는 경우
                    c.병원 방침에 의하여 특정의사 및 진료에 대해 인터넷 진료예약이 불가능하다고 판단되는 경우
                    제5장 병원 및 이용자의 의무
                    제11조 바이오기술센터의 의무
                    (1)바이오기술센터는 시스템 점검 및 서비스 개발, 통신장애, 기타 불가항력적인 사고 등 특별한 사정이 없는 한 이 약관 및 동의서가 정한바에 따라 지속적으로 안정적인 서비스를 제공할 의무가 있습니다.
                    (2)바이오기술센터는 이용자의 신용정보를 포함한 개인신상정보의 보안에 대하여 기술적 안전 조치를 강구하고 관리에 만전을 기함으로써 이용자의 정보보안에 최선을 다합니다.
                    (3)회원은 언제든지 자신의 개인정보를 열람할 수 있고 병원 또는 정보관리책임자에게 잘못된 정보에 대한 정정을 요청할 수 있습니다
                    (4)바이오기술센터는 이용자가 원하지 않는 영리목적의 광고성 전자우편을 발송하지 않습니다.
                    제12조 이용자의 의무
                    (1)이용자는 서비스를 이용할 때 다음 각호의 행위를 하지 않아야 합니다.
                    a.신청 또는 변경 시 허위내용의 등록
                    b.본인 이외의 개인정보, 주민등록번호 및 비밀번호를 부정하게 사용하는 행위
                    c.홈페이지에 게시된 정보의 변경
                    d.서비스를 이용하여 얻은 정보를 회원의 개인적인 이용 외에 복사, 가공, 번역, 2차적 저작 등을 통하여 복제, 공연, 방송, 전시, 배포, 출판 등에 사용하거나 제3자에게 제공하는 행위
                    e.타인의 명예를 손상시키거나 불이익을 주는 행위
                    f.바이오기술센터의 저작권, 제3자의 저작권 등 기타 권리를 침해하는 행위
                    g.공공질서 및 미풍양속에 위반되는 내용의 정보, 문장, 도형, 음성 등을 타인에게 유포하는 행위
                    h.범죄와 결부된다고 객관적으로 인정되는 행위
                    i.서비스와 관련된 설비의 오동작이나 정보 등의 파괴 및 혼란을 유발시키는 컴퓨터 바이러스 감염자료를 등록 또는 유포하는 행위
                    j.서비스의 안정적 운영을 방해할 수 있는 정보를 전송하거나 수신자의 의사에 반하여 광고성 정보를 전송하는 행위
                    k.기타 관계법령 및 의료규정에 위배되는 행위
                    (2)이용자는 서비스 이용시 아이디와 비밀번호 사용에 대한 다음과 같은 의무를 이행해야 합니다.
                    a.이용자는 바이오기술센터홈페이지 서비스를 이용하는 경우, 본인의 아이디 및 비밀번호를 사용해야 합니다.
                    b.아이디와 비밀번호에 관한 모든 관리의 책임은 이용자에게 있습니다.
                    c.이용자는 자신의 아이디 및 비밀번호를 제3자에게 이용하게 해서는 안됩니다
                    d.이용자의 아이디 및 비밀번호의 관리의 부실로 인한 모든 책임은 이용자가 부담합니다.
                    e.이용자는 아이디 및 비밀번호를 도난당하거나 제3자에게 사용되고 있음을 인지한 경우에는 바로 바이오기술센터에 통보하고 바이오기술센터의 안내가 있는 경우에는 그에 따라야 합니다.
                </textarea><br>
                <input type="checkbox" name="" id=""> 위의 이용약관을 읽고 이해했습니다.<br><br><br>
                <h4>개인정보 처리방침 동의</h4>
                <textarea name="" id="" cols="175" rows="20">
                    FullLife는 법령의 규정에 따라 수집·보유 및 처리하는 개인정보를 공공업무의 적절한 수행과 정보주체의 권익을 보호하기 위하여 적법하고 적정하게 취급할 것입니다. 또한, 진흥원은 관련 법령에서 규정한 바에 따라 진흥원에서 보유하고 있는 개인정보에 대한 열람청구권 및 정정청구권 등 이용자의 권익을 존중하며, 여러분은 이러한 법령상 권익의 침해 등에 대하여 행정심판법에서 정하는바에 따라 행정심판을 청구할 수 있으며, 개인정보분쟁조정위원회, 개인정보침해신고센터 등에 분쟁해결이나 상담 등을 신청할 수 있습니다. 진흥원의 개인정보 처리방침은 현행 「개인정보보호법」에 근거를 두고 있습니다. 개인정보를 처리하는 우리원 소관 홈페이지의 경우 해당 홈페이지에 별도의 개인정보처리방침을 정하여 운영하고 있습니다.
                    제1조 개인정보의 처리 목적
                    FullLife는 소관 업무 수행 및 민원처리 등의 목적으로 최소한으로 개인정보를 수집하고 있으며, 자세한 사항은 각 부서에서 운영하는 소관 홈페이지에 게재하여 정보주체가 확인할 수 있도록 안내를 하고 있습니다. 당 홈페이지에는 수집하는 개인정보 항목이 없음을 알려드립니다.
                    
                    제2조 개인정보의 처리 및 보유기간
                    FullLife에서 처리하는 개인정보는 수집·이용 목적으로 명시한 범위 내에서 처리하며, 개인정보 보호법 및 관련 법령에서 정하는 보유기간을 준용하여 이행하고 있습니다.
                    
                    제3조 개인정보의 제3자 제공에 관한 사항
                    FullLife는원칙적으로 이용자의 개인정보를 수집·이용 목적으로 명시한 범위 내에서 처리하며, 이용자의 사전동의 없이는 제3자에게 제공하지 않으며, 다음의 경우에는 개인정보를 제3자에게 제공 할 수 있습니다.
                    1. 정보주체로부터 별도의 동의를 받은 경우
                    2. 법률에 특별한 규정이 있거나 법령상 의무를 준수하기 위하여 불가피한 경우
                    3. 정보주체 또는 그 법정대리인이 의사표시를 할 수 없는 상태에 있거나 주소불명 등으로 사전 동의를 받을 수 없는 경우로서 명백히 정보 주체 또는 제3자의 급박한 생명, 신체, 재산의 이익을 위하여 필요하다고 인정되는 경우
                    4. 개인정보를 목적 외의 용도로 이용하거나 이를 제3자에게 제공하지 아니하면 다른 법률에서 정하는 소관 업무를 수행할 수 없는 경우로서 보호위원회의 심의·의결을 거친 경우
                    5. 조약, 그 밖의 국제협정의 이행을 위하여 외국정부 또는 국제기구에 제공하기 위하여 필요한 경우
                    6. 범죄의 수사와 공소의 제기 및 유지를 위하여 필요한 경우
                    7. 법원의 재판업무 수행을 위하여 필요한 경우
                    8. 형(刑) 및 감호, 보호처분의 집행을 위하여 필요한 경우
                    진흥원이 개인정보를 제3자에게 제공하는 경우 다음의 항목을 이용자에게 알린 후 동의를 받겠습니다.
                    1. 개인정보를 제공받는 자
                    2. 개인정보의 이용 목적(제공 시에는 제공받는 자의 이용 목적을 말한다)
                    3. 이용 또는 제공하는 개인정보의 항목
                    4. 개인정보의 보유 및 이용 기간(제공 시에는 제공받는 자의 보유 및 이용 기간을 말한다)
                    5. 동의를 거부할 권리가 있다는 사실 및 동의 거부에 따른 불이익이 있는 경우에는 그 불이익의 내용
                    
                    제4조 개인정보 처리의 위탁
                    FullLife는 원칙적으로 이용자의 동의없이 해당 개인정보의 처리를 타인에게 위탁하지 않습니다. 다만, 진흥원이 제3자에게 개인정보의 처리업무를 위탁하는 경우에는 위탁 업무의 내용과 수탁자를 해당 서비스의 홈페이지에 게시합니다. 당 홈페이지는 개인정보 처리와 관련한 별도의 위탁사항이 없음을 알려드립니다.
                    </textarea>><br>
                    <input type="checkbox" name="" id="">위의 개인정보 수집 및 이용에 관한 약관을 읽고 이해했습니다.            
            </div>
        </div><br>
        <div id="btn-reserve">
            <input type="submit" value="예약하기">
        </div>
    </main>
    <footer>
    	<jsp:include page="/HeaderNFooterJSP/Footer.jsp"></jsp:include>
    </footer>
</body>
</html>

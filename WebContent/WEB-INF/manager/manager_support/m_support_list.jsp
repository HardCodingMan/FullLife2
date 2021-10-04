<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FullLife</title>
<link rel="stylesheet" href="/m_css/m_support_list.css">
</head>
<body>
    <header>
        <div id="logo">
            <a href="#"><img src="/img/fulllife로고3 (1).png" alt=""></a>
        </div>
        <div id="logout">
            <button>로그아웃</button>
        </div>
    </header>
    <aside id="left-aside">
        <div id="main-ul">
            <ul>
                <li class="main-li"><a href="/manager/m_member_list">&nbsp;회원 정보 관리</a></li>
                <li class="main-li"><a href="/manager/m_order_list">&nbsp;주문 관리</a></li>
                <li class="serv-li" id="choice">
                    <a href="/manager/m_support_list">&nbsp;게시판 관리</a>
                    <div class="board-class">
                        <ul>
                            <li><a href="/manager/m_support_list">후원 게시판</a></li>
                            <li><a href="/manager/m_apply_list">신청 게시판</a></li>
                            <li><a href="/manager/m_ask_list">문의 게시판</a></li>
                            <li><a href="/manager/m_result_list">검사 결과 관리</a></li>
                        </ul>
                    </div>
                </li>
            </ul>
        </div>
    </aside>
    <div id="main-div">
        <div id="title">
            후원 게시판 관리
        </div>
        <div id="line-div"></div>
        <div id="contents">
                <div id="list-div">
                <div class="search-div">
                    <form>
                    <input type="text" id="search" value="제목을 검색하세요">&nbsp;&nbsp;&nbsp;
                    <input type="submit" id="search-btn" value="검색">
                    </form>    
                </div>
                    <div class="list">
                        <div class="list-img">
                            <img src="/img/insta1.jpg" alt="후원1">
                        </div>
                        <div class="list-text">
                            <a href="/manager/m_support_reply">우리 동생이..</a> 
                        </div>
                        <div class="list-percent">                      
                            달성률
                            <div class="prog">
                                <div class="progs" id="progressing">80%</div>
                            </div>
                        </div>
                        <div class="list-btn">
                            <form action="">
                                <input type="submit" value="글 숨기기">
                            </form>
                        </div>
                    </div>
                    <div class="list">
                        <div class="list-img">
                            <img src="/img/insta2.jpg" alt="후원1">
                        </div>
                        <div class="list-text">
                            <a href="/manager/m_support_reply">돈이 없어 수술을..</a> 
                        </div>
                        <div class="list-percent">
                            달성률
                            <div class="prog">
                                <div class="progs" id="progressing">80%</div>
                            </div>
                        </div>
                        <div class="list-btn">
                            <form action="">
                                <input type="submit" value="글 숨기기">
                            </form>
                        </div>
                    </div>
                    <div class="list">
                        <div class="list-img">
                            <img src="/img/insta3.jpg" alt="후원1">
                        </div>
                        <div class="list-text">
                            <a href="/manager/m_support_reply">기부금이..</a> 
                        </div>
                        <div class="list-percent">
                            달성률
                            <div class="prog">
                                <div class="progs" id="progressing">80%</div>
                            </div>
                        </div>
                        <div class="list-btn">
                            <form action="">
                                <input type="submit" value="글 숨기기">
                            </form>
                        </div>
                    </div>
                    <div class="list">
                        <div class="list-img">
                            <img src="/img/insta4.jpg" alt="후원1">
                        </div>
                        <div class="list-text">
                            <a href="/manager/m_support_reply">우리 오빠가..</a> 
                        </div>
                        <div class="list-percent">
                            달성률
                            <div class="prog">
                                <div class="progs" id="progressing">80%</div>
                            </div>
                        </div>
                        <div class="list-btn">
                            <form action="">
                                <input type="submit" value="글 숨기기">
                            </form>
                        </div>
                    </div>
                    <div class="list">
                        <div class="list-img">
                            <img src="/img/insta5.jpg" alt="후원1">
                        </div>
                        <div class="list-text">
                            <a href="/manager/m_support_reply">이쁜 우리 언니..</a> 
                        </div>
                        <div class="list-percent">
                            달성률
                            <div class="prog">
                                <div class="progs" id="progressing">80%</div>
                            </div>
                        </div>
                        <div class="list-btn">
                            <form action="">
                                <input type="submit" value="글 숨기기">
                            </form>
                        </div>
                    </div>
                    <div class="list">
                        <div class="list-img">
                            <img src="/img/insta6.jpg" alt="후원1">
                        </div>
                        <div class="list-text">
                            <a href="/manager/m_support_reply">모델 출신 오빠가..</a> 
                        </div>
                        <div class="list-percent">
                            달성률
                            <div class="prog">
                                <div class="progs" id="progressing">80%</div>
                            </div>
                        </div>
                        <div class="list-btn">
                            <form action="">
                                <input type="submit" value="글 숨기기">
                            </form>
                        </div>
                    </div>
                    <div class="list">
                        <div class="list-img">
                            <img src="/img/insta7.jpg" alt="후원1">
                        </div>
                        <div class="list-text">
                            <a href="/manager/m_support_reply">사랑해요</a> 
                        </div>
                        <div class="list-percent">
                            달성률
                            <div class="prog">
                                <div class="progs" id="progressing">80%</div>
                            </div>
                        </div>
                        <div class="list-btn">
                            <form action="">
                                <input type="submit" value="글 숨기기">
                            </form>
                        </div>
                    </div>
                    <div class="list">
                        <div class="list-img">
                            <img src="/img/insta8.jpg" alt="후원1">
                        </div>
                        <div class="list-text">
                            <a href="/manager/m_support_reply">힘들어요</a> 
                        </div>
                        <div class="list-percent">
                            달성률
                            <div class="prog">
                                <div class="progs" id="progressing">80%</div>
                            </div>
                        </div>
                        <div class="list-btn">
                            <form action="">
                                <input type="submit" value="글 숨기기">
                            </form>
                        </div>
                    </div>
                <div class="list">
                    <div class="list-img">
                        <img src="/img/insta9.jpg" alt="후원1">
                    </div>
                    <div class="list-text">
                        <a href="/manager/m_support_reply">이제 그만..</a> 
                    </div>
                    <div class="list-percent">
                        달성률
                        <div class="prog">
                            <div class="progs" id="progressing">80%</div>
                        </div>
                    </div>
                    <div class="list-btn">
                        <form action="">
                            <input type="submit" value="글 숨기기">
                        </form>
                    </div>
                </div>
            </div>
        </div>
</body>
</html>
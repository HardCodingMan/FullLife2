<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FullLife</title>
<link rel="stylesheet" href="/m_css/m_support_reply.css">
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
            <div id="notice-div">
                <div id="date-div">
                    <div id="date">2021.09.23</div>
                    <div id="view">조회수 : 8,123</div>
                </div>
                    <div id="post">
                        <div id="post-header">
                            <span>저희 bj 누나가..</span>
                        </div>
                        <div id="post-contents">
                            <div id="post-img">
                                <img src="/img/m1.png" alt="">
                            </div>
                            <div id="post-text">
                                로렘 입숨(lorem ipsum; 줄여서 립숨, lipsum)은 출판이나 그래픽 디자인 분야에서 폰트, 타이포그래피, 레이아웃 같은 그래픽 요소나 
                                시각적 연출을 보여줄 때 사용하는 표준 채우기 텍스트로, 최종 결과물에 들어가는 실제적인 문장 내용이 채워지기 전에 시각 디자인 
                                프로젝트 모형의 채움 글로도 이용된다. 이런 용도로 사용할 때 로렘 입숨을 그리킹(greeking)이라고도 부르며, 때로 로렘 입숨은 공간만
                                차지하는 무언가를 지칭하는 용어로도 사용된다. 로렘 입숨은 전통 라틴어와 닮은 점 때문에 종종 호기심을 유발하기도 하지만 그 이상의 
                                의미를 담지는 않는다. 문서에서 텍스트가 보이면 사람들은 전체적인 프레젠테이션보다는 텍스트에 담긴 뜻에 집중하는 경향이 있어서 출판사들은 
                                서체나 디자인을 보일 때는 프레젠테이션 자체에 초점을 맞추기 위해 로렘 입숨을 사용한다.
                            </div>
                            <div id="post-footer">
                                    <div id="footer1">
                                        <span>목표 금액 : </span>
                                        <span>20,000,000</span>
                                    </div>
                                    <div id="footer2">
                                        <span>달성률 : </span>
                                        <span>80%</span>
                                    </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="notice-footer">
                    <div id="reply-header">
                        후원 댓글 2개
                    </div>
                    <div id="reply">
                       <table>
                            <tr>
                                <th>dlthfal44</th>
                                <th>댓글입니다.</th>
                                <th><input type="submit" value="삭제"></th>
                            </tr>
                            <tr>
                                <th>dbsgustjr55</th>
                                <th>댓글입니다.</th>
                                <th><input type="submit" value="삭제"></th>
                            </tr>
                       </table>
                    </div>
                </div>
            <div id="back">
                    <input type="submit" value="목록">
            </div>
        </div>
    </div>

</body>
</html>
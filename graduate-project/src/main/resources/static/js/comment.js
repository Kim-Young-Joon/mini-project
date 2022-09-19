$(document).ready(function () {
    // 게시글의 아이디 받아오는 부분 필요
    // 다시 같은 url 로 post 요청 보내기 위함
    let postId = $('#postId');

    // 댓글 가져오기 -> GET
    // 댓글 출력 -> POST

    let comment = {
        user: $("#user").val(),
        content: $("#content").val()
    }

    $.ajax({
        async : true,
        url : '/posts/' + postId, // 댓글 가져올 url -> controller mapping
        type : 'GET',
        timeout : 3000, // ms 단위 -> 시간 내에 응답 안오면 실패로 간주함 (즉, 3초 내에 응답)
        data : comment,
        success : function() {
            alert('서버 응답 성공 확인');

            // $("#comment").each(data, function() {});
            // each 통해서 댓글 출력 x -> thymeleaf 에서 th:each 활용하여 출력
        },
        error : function() {
            alert('서버 응답 실패');
        }
    });
});
/*
    1. 데이터 받아오는 형태 확인
    2. 게시판 세부 보기 화면에서 미리 댓글 영역 잡혀 있는 상태 -> 이 곳으로 데이터 집어 넣어야 함
    3. 댓글 받아오는 class 하나 두고 (작성자명, 댓글 내용) -> 이를 이용해서 댓글 받아야 함

    ++ 댓글 보기 버튼을 눌렀을 때 댓글이 보여지는 형태로 구현
       이후 추가되는 댓글은 바로 업데이트
    ++ 로그인 되어 있는 사용자명은 세션에서 가져와서 별도의 작성자 입력은 없도록 구현

    댓글 수정
 */
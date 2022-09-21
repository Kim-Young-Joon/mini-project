// 댓글 등록하기
$("#btn-commentSave").click(function() {
    let myData = $("#commentContent").val();
    let userName = $("#username").val();
    let getCommentUrl = "/posts/" + $("#postId").html() + "/comments";
    let saveCommentUrl = "/posts/" + $("#postId").html() + "/comments/"

    $.ajax({
        type:'POST',
        url : saveCommentUrl, // 댓글 등록
        data : JSON.stringify(
            {
                "name" : userName,
                "comment": myData,
            }
        ),
        contentType: 'application/json',
        success : function(data){
            if(data=="success")
            {
                getCommentList(getCommentUrl);
                $("#commentContent").val(""); // 등록후 입력창 초기화
            }
        },
        error : function(request,status,error){
            alert("댓글 등록 오류")
        }
    });

});

// 초기 로딩시 댓글 불러오기
$(function() {
    let getCommentUrl = "/posts/" + $("#postId").html() + "/comments"
    console.log(getCommentUrl);
    getCommentList(getCommentUrl);
});

// 댓글 불러오기
function getCommentList(myUrl){
    $.ajax({
        type:'GET',
        url : myUrl,
        dataType : "json",
        data: $("#CommentList"),
        contentType: "",
        success : function(data){
            let html = "";
            let cCnt = data.length;

            if(data.length > 0){
                for(i=0; i<data.length; i++){
                    html += "<div>";
                    // html += "<div><table class='table'><h6><strong>"+data[i].writer+"</strong></h6>";
                    // html += data[i].comment + "<tr><td></td></tr>";
                    // html += "</table></div>";
                    html += "test";
                    html += "</div>";
                }
            } else {
                html += "<div>";
                html += "<div><table class='table'><h6><strong>등록된 댓글이 없습니다.</strong></h6>";
                html += "</table></div>";
                html += "</div>";
            }

            $("#cCnt").html(cCnt);
            $("#commentList").html(html);
        },
        error : function(request,status,error){
            alert("댓글 가져오기 오류")
        }
    });
}

/*
    1. 데이터 받아오는 형태 확인
    2. 게시판 세부 보기 화면에서 미리 댓글 영역 잡혀 있는 상태 -> 이 곳으로 데이터 집어 넣어야 함
    3. 댓글 받아오는 class 하나 두고 (작성자명, 댓글 내용) -> 이를 이용해서 댓글 받아야 함

    ++ 댓글 보기 버튼을 눌렀을 때 댓글이 보여지는 형태로 구현
       이후 추가되는 댓글은 바로 업데이트
    ++ 로그인 되어 있는 사용자명은 세션에서 가져와서 별도의 작성자 입력은 없도록 구현

    댓글 수정
 */
var posts = {
    init : function () {
        var _this = this;
        
        $('#btn-submit').on('click', function () {
            _this.save();
        });
        
    },
    save : function () {
        var data = {
        	title: $('#title').val(),
        	author: $('#author').val(),
            content: $('#note-body').val()
        };

        $.ajax({
            type: 'POST',
            url: '/posts',
            contentType:'application/json; charset=utf-8',
            dataType: 'json',
            data: JSON.stringify(data)
        }).done(function() {
        	alert('글이 등록되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(error);
        });
    }

};

posts.init();
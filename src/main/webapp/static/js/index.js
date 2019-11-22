var page = 1,
    rows = 3;
$(function(){
	initJqPaginator();
	load_redis_list();
});

//初始化分页
function initJqPaginator() {
    $.jqPaginator('#pagination', {
        totalPages: 100,
        visiblePages: 10,
        currentPage: 1,
        first: '<li class="prev"><a href="javascript:;">首页</a></li>',
        last: '<li class="prev"><a href="javascript:;">末页</a></li>',
        prev: '<li class="prev"><a href="javascript:;">上一页</a></li>',
        next: '<li class="next"><a href="javascript:;">下一页</a></li>',
        page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
        onPageChange: function (num, type) {
            page = num;
            if (type == "change") {
                load_redis_list();
            }
        }
    });
}


//加载列表
function load_redis_list() {
    $.ajax({
        type: 'POST',
        url:  '/IBeauty/toIndex',
        async: false,
        data: {page: page, pageSize: rows},
        datatype: 'json',
        success: function (data) {     	
        	if(data.success){
    			var productlist = data.productlist;
    			var html = '';
    			productlist.map(function(item,index){
    				html += ''+"<li>"
    				+ "<a href='toDetail.do?productid="
    				+ item.id
    				+ "' target='_blank'>"
    				+ "<div class='pic'><img class='lazy' src='static/"
    				+ item.src
    				+ "' aitem='"
    				+ item.detail
    				+ "' style='display: inline;'></div>"
    				+ "<div class='tit'>"
    				+ item.detail
    				+ "'</div>'"
    				+ "<div class='price_tuan'><div class='price'>￥<strong>"
    				+ item.price + "</strong></div></div>" + "</a>"
    				+ "</li>";
    			});
    			//alert(html);
    			$(".commodity").html(html);
                           
                //这里是分页的插件
                $('#pagination').jqPaginator('option', {
                    totalPages: (Math.ceil(count / rows) < 1 ? 1 : Math.ceil(count / rows)),
                    currentPage: page
                });
            } else {
                alert(data.msg);
            }
        }
    });
    $(".product_box:even").css("background", "#e6e6e6");//隔行变色
}

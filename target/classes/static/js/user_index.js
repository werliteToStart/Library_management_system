$(document).ready(function (){

});
var where,user_role_id;
function searchBook(element){
    let value = $('#value').val();
    let href;
    if (user_role_id === 2 || user_role_id === 3){
        if (value === ''){
            value = "error";
        }
        href = '/admin/queryAllBook/'+where+'/'+value;
    }else{
        if (value === ''){
            value = "error";
        }
        href = '/book/queryAllBook/'+where+'/'+value;
    }
    $(element).attr('href',href);
}
function queryBookByWhere(role_id,element){
    let text = $(element).text();
    $('#dropdownMenuButton').html(text+'<span class="caret"></span>')

    where = $(element).data('value');
    user_role_id = role_id;
}
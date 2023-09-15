$(document).ready(function(){
  //alert("Call");
});

function saveCategory(){
	if(($("#name").val() !='') && ($("#description").val() !='')){
			
		document.getElementById("saveCategory").disabled = true;
		document.getElementById("saveCategory").classList.add('button-saving');
		
		//var newCategory = new FormData(document.getElementById("newCategory"));
		//var form = new FormData($('#newCategory')[0]);
		var newCategory = {
			categoryId 	: document.getElementById("categoryId").value,
			name	 	: document.getElementById("name").value,
			description	: document.getElementById("description").value,
			image		: document.getElementById("image").value
		}
		
		$.ajax({
			url: '/api/saveCategory',
			type: 'POST',
			data: newCategory,
			cache: false,
	        success:function (response) {
				
				document.getElementById("saveCategory").disabled = false;
				document.getElementById("saveCategory").classList.remove('button-saving');
				
				Swal.fire(
			      'Successful!',
			      'Your record has been added',
			      'success'
			     ).then(function() {
				    window.location = "/listCategories";
				 });
			},
			error:function(status, error){
				document.getElementById("saveCategory").disabled = false;
				 Swal.fire(
			      'Can not insert!',
			      'Something went wrong',
			      'error'
			    )
			}
		});		
	}
	else{
		Swal.fire(
	      'Can not insert!',
	      'Something went wrong',
	      'error'
	    )
	}
}

function updateCategory(categoryId){
	$.ajax({
		url: '/api/getCategory',
		type: 'GET',
		traditional: true,
		data: {categoryId: categoryId},
		success: function (category) {
		    document.getElementById("categoryId").value = category["categoryId"];
			document.getElementById("name").value = category["name"];
			document.getElementById("description").value = category["description"];
			document.getElementById("image").value = category["image"];
			document.getElementById("status").value = category["status"];
			document.getElementById("createBy").value = category["createBy"];
			document.getElementById("createDate").value = category["createDate"];
			document.getElementById("updateBy").value = category["updateBy"];
			document.getElementById("updateDate").value = category["updateDate"];
			
			document.getElementById("addCategory").click();
		},
		error:function(status, error){
			 Swal.fire(
		      'Can not delete!',
		      'Record has relation data',
		      'error'
		    )
		}
	});
}

function deleteCategory(categoryId){
	alert("deleteCategory " + categoryId);
}

function deactiveCategory(categoryId){
	alert("deactiveCategory " + categoryId);
}

function activeCategory(categoryId){
	alert("activeCategory " + categoryId);
}
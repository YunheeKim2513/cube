var root = "/cubegroupware";

var control = "/adminhome";

$(document).ready(function(){ 
/*	
	$.ajax({
		type : "POST",
		dataType : 'text',// 데이타 타입을 text으로 받겠다.
		url : root + control,
		data : {
			act : "chart"
		},
		success : function(data) {// 알아서 맞춰준다.
			
		},
		error : function(e) {
			alert("에러!");
		}
	});
	*/
    var s1 = [['Sony',7], ['Samsumg',13.3], ['LG',14.7], ['Vizio',5.2], ['Insignia', 1.2]];
         
     $.jqplot('chart_div1', [s1], {
        grid: {
            drawBorder: false, 
            drawGridlines: false,
            background: '#ffffff',
            shadow:false
        },
        axesDefaults: {
             
        },
        seriesDefaults:{
            renderer:$.jqplot.PieRenderer,
            rendererOptions: {
                showDataLabels: true
            }
        },
        legend: {
            show: true,
            rendererOptions: {
                numberRows: 1
            },
            location: 's'
        }
    }); 
});



$(document).ready(function(){ 
    var s1 = [['Sony',7], ['Samsumg',13.3], ['LG',14.7], ['Vizio',5.2], ['Insignia', 1.2]];
         
    var plot8 = $.jqplot('chart_div2', [s1], {
        grid: {
            drawBorder: false, 
            drawGridlines: false,
            background: '#ffffff',
            shadow:false
        },
        axesDefaults: {
             
        },
        seriesDefaults:{
            renderer:$.jqplot.PieRenderer,
            rendererOptions: {
                showDataLabels: true
            }
        },
        legend: {
            show: true,
            rendererOptions: {
                numberRows: 1
            },
            location: 's'
        }
    }); 
});
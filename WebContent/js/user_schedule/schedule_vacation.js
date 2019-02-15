
	var root="/cubegroupware"


	  google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          ['Work',     11],
          ['Eat',      2],
          ['Commute',  2],
          ['Watch TV', 2],
          ['Sleep',    7]
        ]);

        var options = {
          title: 'My Daily Activities',
          pieHole: 0.4,
        };

        var chart = new google.visualization.PieChart(document.getElementById('donutchart1'));
        chart.draw(data, options);
        
        var chart = new google.visualization.PieChart(document.getElementById('donutchart2'));
        chart.draw(data, options);
      }
   
      
      
      function today() {
    		var date = new Date();
    		var m = date.getMonth()+1;
    		var d = date.getDate();
    		return date.getFullYear()+'-'+(m>9?m:'0'+m)+'-'+(d>9?d:'0'+d);
    	}
      
      function start(){
    	  var date = new Date();
  		var m = date.getMonth()+1;
  		var d = date.getDate()+1;
  		return date.getFullYear()+'-'+(m>9?m:'0'+m)+'-'+(d>9?d:'0'+d);
      }
      function end(){
    	  var date = new Date();
  		var m = date.getMonth()+1;
  		var d = date.getDate()+2;
  		return date.getFullYear()+'-'+(m>9?m:'0'+m)+'-'+(d>9?d:'0'+d);
      }
      
      var search_list;
      
/*
 * function getList(){ $.ajax({ type: "POST", dataType: 'json', url:
 * root+"/schedule_all", data: { act: "list" }, success:function(data) {
 *  }, error: function(e){ alert("Error!!"); } }); }
 */
	$(document).ready(function() {
		$('#calendar').fullCalendar({
			header: {
				left: 'prev,next today',
				center: 'title',
				right: ''
				// right: 'month,agendaWeek,agendaDay,listWeek'
			},
			defaultDate: today(),
			navLinks: true, // can click day/week names to navigate views
			editable: true,
			eventLimit: true, // allow "more" link when too many events
			
			events: function(start,end,timezone,callback){
				var t;
				var s;
				var e;
				$.ajax({
					dataType: 'xml',
					url: root+"/schedule_vacation",
					data: { act: "xml" },
					success: function(doc){
						var events=[];
						$(doc).find('vacationlist').find('vacation').each(function(){
							var a=$(this)[0].nodeName;
							var len=a.length;
							for(var i=0;i<len;i++){
								t=$(this).find('employee').text();
								s=$(this).find('startdate').text();
								e=$(this).find('enddate').text();
							}
							events.push({
								title: t,
								start: s,
								end: e
							});
						});		
						callback(events);
					},
					error: function(e){
						alert("Error!!");
					}
				});
			},
			// eventClick: function(calEvent, jsEvent, view) {
			eventClick: function(event) {
		    },
		    dayClick: function(date, jsEvent, view) {
		    	var date=date.format().split("-");
			       var year=date[0];
			       var month=date[1];
			       var day=date[2];
			       document.getElementById("startyear").value=year;
			       document.getElementById("startmonth").value=month;
			       document.getElementById("startday").value=day;
			       document.getElementById("endyear").value=year;
			       document.getElementById("endmonth").value=month;
			       document.getElementById("endday").value=day;
			       $('#schedulewrite').modal('show')
		    }
		});
	});

	

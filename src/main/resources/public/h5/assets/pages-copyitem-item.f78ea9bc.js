import{L as t,M as e,N as a,o as s,b as o,w as i,k as n,j as r,t as c,d as l,e as h,F as d,m as u,C as m,O as g,P as p,q as f}from"./index.5bee6499.js";import{u as v,_ as y,a as T,b as C,c as b}from"./u-charts.min.7f9e5c93.js";import{c as _,r as k}from"./config.cf703286.js";import{_ as w}from"./plugin-vue_export-helper.21dcd24c.js";var x={};var F=w({data:()=>({cWidth:750,cHeight:500,info:"信息",matchlist:["比赛1：","比赛2："],option:{}}),onReady(){this.cWidth=t(750),this.cHeight=t(500)},onLoad:function(t){console.log(t.id),console.log(t.name),this.info="姓名："+t.name+"\n学号："+t.number,this.option=t,this.getServerData(t,10)},methods:{getServerData(t,e){null==t.id&&(t.id=226),_.request({url:"searchcopybystudent?studentId="+t.id+"&size="+e,data:{},success:t=>{var e=t.data.data.item,a=t.data.data.aLLscores;this.info=this.info+"\n总成绩："+a;for(var s=[],o=0;o<e.length;o++){null==(c=e[e.length-o-1]).score&&(c.score=0),s.push("比赛"+(o+1)+"："+c.name)}this.matchlist=s;var i={categories:[],series:[{name:"比赛成绩",data:[]}]};for(o=0;o<e.length;o++){null==(c=e[e.length-o-1]).score&&(c.score=0),"初始积分"==c.name?(i.categories.push(o+1),i.series[0].data.push(0)):(i.categories.push(o+1),i.series[0].data.push(c.score))}this.drawCharts("myid2",i);var n={categories:[],series:[{name:"比赛成绩",data:[]}]};for(o=0;o<e.length;o++){null==(c=e[o]).score&&(c.score=0),n.categories.push(o+1),a-=c.score,n.series[0].data.unshift(a+c.score)}this.drawCharts("myid",n);var r={categories:[],series:[{name:"排名",data:[]}]};for(o=0;o<e.length;o++){var c;null==(c=e[e.length-o-1]).score&&(c.score=0);for(var l=t.data.data.rank,h=0;h<l.length;h++){var d=l[h];c.matchId==d.matchId&&(r.categories.push(o+1),r.series[0].data.push(d.rank))}}this.drawCharts("myid3",r)}})},drawCharts(t,a){const s=e(t,this);x[t]=new v({type:"line",context:s,width:this.cWidth,height:this.cHeight,categories:a.categories,series:a.series,animation:!0,background:"#FFFFFF",color:["#1890FF","#91CB74","#FAC858","#EE6666","#73C0DE","#3CA272","#FC8452","#9A60B4","#ea7ccc"],padding:[15,10,0,15],enableScroll:!0,legend:{},xAxis:{disableGrid:!0,scrollShow:!0,itemCount:10},yAxis:{gridType:"dash",dashLength:2},extra:{line:{type:"straight",width:2,activeType:"hollow"}}})},touchstart(t){x[t.target.id].scrollStart(t)},touchmove(t){x[t.target.id].scroll(t)},touchend(t){x[t.target.id].scrollEnd(t),x[t.target.id].touchLegend(t),x[t.target.id].showToolTip(t)},handleClick(){this.getServerData(this.option,50),a({title:"比赛列表已增加",icon:"exception",duration:850})}}},[["render",function(t,e,a,v,_,w){const x=u,F=k(m("uni-card"),y),L=k(m("uni-section"),T),S=k(m("uni-list-item"),C),j=k(m("uni-list"),b),A=g,D=p,E=f;return s(),o(E,null,{default:i((()=>[n(L,{title:"个人信息",type:"line"},{default:i((()=>[n(F,{title:"我的信息","sub-title":"",extra:"",thumbnail:t.avatar,onClick:t.onClick},{default:i((()=>[n(x,{class:"uni-body"},{default:i((()=>[r(c(_.info),1)])),_:1})])),_:1},8,["thumbnail","onClick"])])),_:1}),n(F,{title:"比赛列表","sub-title":"",extra:"",thumbnail:t.avatar,onClick:t.onClick},{default:i((()=>[(s(!0),l(d,null,h(_.matchlist,((t,e)=>(s(),o(j,{key:e},{default:i((()=>[n(S,{title:t},null,8,["title"])])),_:2},1024)))),128))])),_:1},8,["thumbnail","onClick"]),n(L,{title:"总分趋势折线图",type:"line"},{default:i((()=>[n(A,{"canvas-id":"myid",id:"myid",class:"charts",onTouchstart:w.touchstart,onTouchmove:w.touchmove,onTouchend:w.touchend},null,8,["onTouchstart","onTouchmove","onTouchend"])])),_:1}),n(L,{title:"单场比赛趋势图",type:"line"},{default:i((()=>[n(A,{"canvas-id":"myid2",id:"myid2",class:"charts",onTouchstart:w.touchstart,onTouchmove:w.touchmove,onTouchend:w.touchend},null,8,["onTouchstart","onTouchmove","onTouchend"])])),_:1}),n(L,{title:"比赛排名趋势图",type:"line"},{default:i((()=>[n(A,{"canvas-id":"myid3",id:"myid3",class:"charts",onTouchstart:w.touchstart,onTouchmove:w.touchmove,onTouchend:w.touchend},null,8,["onTouchstart","onTouchmove","onTouchend"])])),_:1}),n(E,{class:"button-sp-area"},{default:i((()=>[n(D,{type:"primary",plain:"true",onClick:w.handleClick},{default:i((()=>[r("查看更多")])),_:1},8,["onClick"])])),_:1})])),_:1})}],["__scopeId","data-v-43f4a331"]]);export{F as default};

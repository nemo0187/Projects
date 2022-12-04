var gl;
var theta;
var thetaLoc;
var isDirClockwise = false;
var start_stop=0;
var delay = 50;
var indices;
//Scale-------
var scale=1;
var scaleloc;
//Slide-------
var slidex;
var slidexval=0;
var slidexloc;
var slidey;
var slideyval=0;
var slideyloc;
//------------

window.onload = function init() {

	const canvas = document.querySelector("#glcanvas");
	// Initialize the GL context
	gl = WebGLUtils.setupWebGL(canvas);
	// Only continue if WebGL is available and working
	if (!gl) {
	alert("Unable to initialize WebGL. Your browser or machine may not support it.");
	return;
	}
  
	var program = initShaders(gl, "vertex-shader", "fragment-shader")
	gl.useProgram( program );
    //Butonlar//////////////////////////////////////
	var fasterbtn= document.getElementById("Faster");
    fasterbtn.addEventListener("click",function(){
        if(delay>10){
            delay=delay/2;
        }
    })
    var slowerbtn=document.getElementById("Slower");
    slowerbtn.addEventListener("click",function(){
        if(delay<300){
            delay=delay*2;
        }
    })
	var chngbtn = document.getElementById("DirectionButton"); 
	chngbtn.addEventListener("click", function(){
        isDirClockwise=!isDirClockwise;
    });
	var stopbtn=document.getElementById("StopButton");
    stopbtn.addEventListener("click",function(){
        start_stop+=1;
        delay=50;
    });
    var scalup=document.getElementById("scaleup");
    scalup.addEventListener("click",function(){
        if(scale+0.05<2){
            scale+=0.05;
        }
    })
    var scaldown=document.getElementById("scaledown");
    scaldown.addEventListener("click",function(){
        if(scale-0.05>0.1){
            scale-=0.05;
        }
    })
    var nrmlsize=document.getElementById("normal");
    nrmlsize.addEventListener("click",function(){
        scale=1;
    })
    var slidex=document.getElementById("slidex");
    slidex.addEventListener("change",function(){
        slidexval=slidex.value;
    })
    var slidey=document.getElementById("slidey");
    slidey.addEventListener("change",function(){
        slideyval=slidey.value;
    })

    ///////////////////////////////////////////////////////
	var vertices = [
        vec2(-.6, -.6),
        vec2(.6, -.6),
        vec2(.6, .6),
        vec2(-.6, .6)
        ];

	var bufferId = gl.createBuffer();
	gl.bindBuffer( gl.ARRAY_BUFFER, bufferId );
	gl.bufferData( gl.ARRAY_BUFFER, flatten(vertices), gl.STATIC_DRAW );
    var Index_Buffer = gl.createBuffer();
	var vPosition = gl.getAttribLocation( program, "vPosition" );
	gl.vertexAttribPointer( vPosition, 2, gl.FLOAT, false, 0, 0 );
	gl.enableVertexAttribArray( vPosition );
	
	thetaLoc = gl.getUniformLocation(program, "theta");
	theta = 0;
	gl.uniform1f(thetaLoc, theta);
    scaleloc=gl.getUniformLocation(program,"scale");
    slidexloc=gl.getUniformLocation(program,"slidexval");
    slideyloc=gl.getUniformLocation(program,"slideyval");
	
	// Set clear color to black, fully opaque
	gl.clearColor(0.0, 0.0, 0.0, 1.0);
	
	requestAnimFrame(render);
}

function render(){
	setTimeout(function() {
		// Clear the color buffer with specified clear color
		gl.clear(gl.COLOR_BUFFER_BIT);
        if(start_stop%2!=0){
            theta+=0;
        }
		else{
            theta += (isDirClockwise ? -0.1 : 0.1);
        }
        gl.uniform1f(thetaLoc, theta);
        gl.uniform1f(scaleloc,scale);
        gl.uniform1f(slidexloc,slidexval);
        gl.uniform1f(slideyloc,slideyval);
		gl.drawArrays(gl.TRIANGLE_FAN, 0, 31);
		render();
		}, delay);
}
const fun1= () =>{
    console.log("fun1")
    fun2();
}

const fun2 = () =>{
    setTimeout(()=>{
        console.log("fun2")
    },0);

    fun3();
}

const fun3= () =>{
    console.log("fun3")
}

fun1();
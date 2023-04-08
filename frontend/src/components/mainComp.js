import PropForm from "./propForm"

const MainComp = function(){
    return (<div className="mainComp">
        <div className="appWindow">
            <h1>Property Editor</h1>
            <PropForm />
        </div>
    </div>)
}

export {MainComp}
//import onEffect from react
import { useEffect,useRef,useState } from 'react';

const PropForm = function(){

    
    const [allProps,setCustomProps] = useState([]);
    const currentDBProps = useRef([]);
    

    useEffect(() => {
        fetch('/api/GetAllProps')
        .then(response => response.json())
        .then(data => {
            setCustomProps(data);
            currentDBProps.current = data;
        });
    }, []);
    

    const handleChange = function(event,id,whatChanged){
        const newItems = allProps.map((item)=>{
            if(item["propertyId"] === id){
                if(whatChanged === 'name'){
                    console.log({...item, propName:event.target.value});
                    return {...item, propName:event.target.value};
                }else{
                    console.log({...item, propValue:event.target.value});
                    return {...item, propValue:event.target.value};
                }
            }
            return item;
        });
        setCustomProps(newItems);   
    }

    const handleSubmit = function(){
        console.log("lol");
        allProps.forEach((item)=>{
            currentDBProps.current.forEach((curItem,index)=>{
                if(curItem["propertyId"] === item["propertyId"]){
                    if(curItem["propName"] !== item["propName"] || curItem["propValue"] !== item["propValue"]){
                        fetch('/api/SaveProp',{
                            method:'POST',
                            headers:{'Content-Type':'application/json'},
                            body: JSON.stringify(item)
                          }).then((response) => {
                            if(response.ok){
                                console.log("done");
                                currentDBProps.current[index] = item;
                            }
                          })
                          .catch((error)=>{
                            alert(error.message);
                          });
                    }
                }
            });
        });
        return true;
    }

    const handleDelete = function(index){
        fetch(`/api/DeleteProp/${allProps[index].propertyId}`,{
            method:'DELETE'
          }).then((response) => {
            if(response.ok){
                const newState = [...allProps.slice(0,index),...allProps.slice(index+1)]
                setCustomProps(newState);
            }
          })
          .catch((error)=>{
            alert(error.message);
          });
    }

    return <div>
                <div className="table">{allProps.map((item,index)=>{
                return( 
                    <div className='table-row' key={item["propertyId"]}>
                        <input className='table-item' type='text' value={item["propName"]} onChange={(event)=>handleChange(event,item["propertyId"],"name")}/>
                        <input className='table-item' type='text' value={item["propValue"]} onChange={(event)=>handleChange(event,item["propertyId"],"value")}/>
                        <button type="button" className="table-item btn btn-danger" onClick={()=>handleDelete(index)}>X</button>
                    </div>
                )
                 })}
                 <button className='table-item submitButton btn btn-primary'  onClick={handleSubmit}>Submit</button>
                 </div>
                
        </div>
}

export default PropForm;
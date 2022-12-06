import { useState } from 'react';


const Actors2 = (props) => {
    
    const [actors, setActors] = useState([]);    
    const actorsLi = actors.map( (actor) => <li key={actor.id}>{actor.name}</li> );

    return (
        <>
            <h3>좋아하는 영화 배우 2</h3>
            <ul>
                { actorsLi }
            </ul>
        </>
    );

};

export default Actors2;
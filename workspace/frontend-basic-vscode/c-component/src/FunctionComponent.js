
// const FunctionComponent = (props) => {
//     const { name, email, age } = props; // const name = props.name; const email = props.email
//     return (
//         <div>
//             <h1>This is function component</h1>
//             <h2>[{name}][{email}][{age}]</h2>
//         </div>
//     );
// }

const FunctionComponent = ({ name, email, age }) => {

    return (
        <div>
            <h1>This is function component</h1>
            <h2>[{name}][{email}][{age}]</h2>
        </div>
    );
}

export default FunctionComponent;
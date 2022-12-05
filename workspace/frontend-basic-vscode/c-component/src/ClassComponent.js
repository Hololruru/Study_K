import { Component } from 'react'

class ClassComponent extends Component {

    render() {
        const { name, email, age } = this.props;
        return (
            <div>
                <h1>This is class component</h1>
                <h2>[{this.props.name}][{this.props.email}][{this.props.age}]</h2>
                <h2>[{name}][{email}][{age}]</h2>
            </div>
        );
    }

}

export default ClassComponent
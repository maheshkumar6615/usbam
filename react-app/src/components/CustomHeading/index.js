import React, {Component} from 'react';
import {MapTo} from '@adobe/cq-react-editable-components';
require('./CustomHeading.css');

const CustomHeadingEditConfig = {
    emptyLabel: 'Custom Heading',
    isEmpty: function(props) {
        console.log("hello this is react");
        return !props.heading || props.heading.trim().length < 1;
    }
};
export default class CustomHeading extends Component {
    render() {
      let headingElement = this.props.headingType ? React.createElement(this.props.headingType, {className: this.props.headingColor},this.props.heading) : '';
      return (<div className="heading"> {headingElement}
      <p>{this.props.customValue}</p>
      </div>);
    }
}
MapTo('usbamapp/components/custom-heading')(CustomHeading, CustomHeadingEditConfig);

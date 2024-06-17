import PropTypes from 'prop-types';
import { LinkContent } from './styles';


const CustomLink = ({ to, children, className }) => {
    return (
      <LinkContent to={to} className={`custom-link ${className}`}>
        {children}
      </LinkContent>
    );
  };
  
  CustomLink.propTypes = {
    to: PropTypes.string.isRequired,
    children: PropTypes.node.isRequired,
    className: PropTypes.string,
  };
  
  CustomLink.defaultProps = {
    className: '',
  };
  
  export default CustomLink;
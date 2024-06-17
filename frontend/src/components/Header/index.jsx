import CustomLink from "../Link"
import { ContainerHeader } from "./styles"

export const Header = () => {
    return(
        <ContainerHeader>
            <CustomLink to="/home">Home</CustomLink>
            <CustomLink to="/produtos">Produto</CustomLink>
            <CustomLink to="/desperdicio">Desperdicio</CustomLink>
            <CustomLink to="/sensor">Sensor</CustomLink>
        </ContainerHeader>
    )
}
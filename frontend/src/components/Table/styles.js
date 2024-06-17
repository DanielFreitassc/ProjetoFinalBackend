import styled from "styled-components";

export const ContainerTable = styled.div`
    width: 100%;
`

export const Table = styled.table`
    width: 100%;
    border-spacing: 0;
`

export const TableHead = styled.thead`
`

export const TableRowHead = styled.tr`
    height: 60px;
`

export const TableColumnHead = styled.th`
    border: 1px solid #eaeaea;
    padding: 8px;
`

export const TableBody = styled.tbody`
    
`

export const TableRow = styled.tr`
    width: 100%;
    height: 60px;
    font-size: 18px;

    &:nth-child(odd) {
        background-color: #f0f0f0;
    }

    &:hover {
        color: white;
        background-color: gray;
        cursor: pointer;
    }

    &:last-child{
        td:last-of-type{
            border-bottom-right-radius: 5px;
        }

        td:first-of-type{
            border-bottom-left-radius: 5px;
        }
    }
`


export const TableColumnBody = styled.td`
    border: 1px solid #eaeaea; 
    padding: 8px; 
`;
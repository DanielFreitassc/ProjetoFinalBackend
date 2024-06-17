
import { privateAPi } from "../../services/privateApi";

import { useEffect, useState } from "react";
import TablePagination from "@mui/material/TablePagination";
import { ContainerProducts } from "./styles";
import { TableContent, TableList } from "../../components/Table";
import { Loading } from "../../components/Loading";

export const Products = () => {
    const [products, setProducts] = useState([]);
    const [page, setPage] = useState(0);
    const [rowsPerPage, setRowsPerPage] = useState(5); 
    const [totalElements, setTotalElements] = useState(0); 
    const [isLoading, setIsLoading] = useState(true);
    
    const fetchProducts = async () => {
        try {
            const response = await privateAPi.get(`/products?page=${page}&size=${rowsPerPage}`);
            setProducts(response.data.content);
            setTotalElements(response.data.totalElements); 
        } catch (error) {
            console.error('Error fetching Products:', error);
        } finally {
            setIsLoading(false); // Set loading to false after the request (or in catch block)
            }
    };

    useEffect(() => {
        fetchProducts();
    }, [page, rowsPerPage]);

    const handleChangePage = (event, newPage) => {
        setPage(newPage);
    };

    const handleChangeRowsPerPage = (event) => {
        setRowsPerPage(parseInt(event.target.value, 10));
        setPage(0); 
    };

    return (
        <ContainerProducts>
            {isLoading ? (
            <Loading /> 
            ) : products.length === 0 ? (
            <p>Nenhum produto cadastrado.</p>
            ) : (
            <>
                <TableList
                colsHeader={[
                    { label: "Id" },
                    { label: "Nome" },
                    { label: "Preço" },
                    { label: "Descrição" },
                    { label: "Validade" },
                ]}
                >
                {products.map(({ id, name, price, description, validity }) => (
                    <TableContent
                    key={id}
                    linkTo={`/produtos/${id}`}
                    colsBody={[
                        { cell: id },
                        { cell: name },
                        { cell: price + " R$" },
                        { cell: description },
                        { cell: validity },
                    ]}
                    />
                ))}
                </TableList>
    
                <TablePagination
                component="div"
                count={totalElements}
                page={page}
                onPageChange={handleChangePage}
                rowsPerPage={rowsPerPage}
                onRowsPerPageChange={handleChangeRowsPerPage}
                />
            </>
            )}
        </ContainerProducts>
    );
};

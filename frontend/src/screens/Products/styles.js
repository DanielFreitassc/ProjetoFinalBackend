import styled from 'styled-components';

export const ContainerProducts = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 20px;
    background-color: #f5f5f5;

    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
    }

    th, td {
        border: 1px solid #ddd;
        padding: 8px;
    }

    th {
        padding-top: 12px;
        padding-bottom: 12px;
        text-align: left;
        background-color: #4CAF50;
        color: white;
    }
`;


// Estilos do botão
const Button = styled.button`
    background-color: #007bff; /* Cor de fundo azul */
    color: #ffffff; /* Cor do texto branco */
    font-size: 16px; /* Tamanho da fonte */
    padding: 10px 20px; /* Espaçamento interno */
    border: none; /* Sem borda */
    border-radius: 5px; /* Borda arredondada */
    cursor: pointer; /* Cursor ao passar */
    transition: background-color 0.3s ease; /* Transição suave de cor de fundo */
    margin: 20px;
    /* Estilos quando hover */
    &:hover {
        background-color: #0056b3; /* Cor de fundo mais escura ao passar */
    }
`;

export default Button;

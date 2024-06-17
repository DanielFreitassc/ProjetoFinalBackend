import { CardContent, ContainerWaste, ContentWaste } from "./styles";
import { privateAPi } from "../../services/privateApi";
import { useState, useEffect } from "react";
import { Loading } from "../../components/Loading";

const imageLow = "./public/Alto.png";
const imageMedium = "./public/Medio.png";
const imageHigh = "./public/Baixo.png";

export const Waste = () => {
  const [wasteData, setWasteData] = useState(null);
  const [isLoading, setIsLoading] = useState(true); 

  useEffect(() => {
    const fetchWaste = async () => {
      try {
        const response = await privateAPi.get("/products/waste");
        setWasteData(response.data);
      } catch (error) {
        console.error("Error fetching waste data:", error);
      } finally {
        setIsLoading(false); 
      }
    };

    fetchWaste();
  }, []);

  return (
    <ContainerWaste>
      {isLoading ? (
        <Loading />
      ) : (
        <CardContent>
          {wasteData && (
            <>
              <h1>Tabela de Desperdício do dia {wasteData.date}</h1>
              <h3>Tipo de comida: {wasteData.foodType}</h3>
              <p>Quantidade: {wasteData.quantity}</p>
              <p>Alerta: {wasteData.alertMessage}</p>
              <ContentWaste>
                {wasteData.quantity < 20 && <img src={imageLow} alt="Low Quantity" />}
                {wasteData.quantity >= 20 && wasteData.quantity < 50 && (
                  <img src={imageMedium} alt="Medium Quantity" />
                )}
                {wasteData.quantity >= 50 && <img src={imageHigh} alt="High Quantity" />}
              </ContentWaste>
            </>
          )}
          {!wasteData && <p>No waste data available.</p>}
        </CardContent>
      )}
    </ContainerWaste>
  );
};

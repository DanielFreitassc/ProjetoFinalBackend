import { useEffect, useState } from "react";
import { privateAPi } from "../../services/privateApi";
import { ContainerSensor, SensorCard } from "./styles";
import { Loading } from "../../components/Loading";

export const Sensor = () => {
  const [sensorData, setSensorData] = useState(null);

  useEffect(() => {
    const fetchSensorData = async () => {
      try {
        const response = await privateAPi.get("/products/sensor");
        setSensorData(response.data);
      } catch (error) {
        console.error("Error fetching sensor data:", error);
      }
    };

    fetchSensorData();
  }, []);

  return (
    <ContainerSensor>
      {sensorData && (
        <SensorCard>
          <h2>Dados do Sensor</h2>
          <ul>
            <li>
              <span>Umidade:</span> {sensorData.umidade} {sensorData.umidadeMensagem}
            </li>
            <li>
              <span>Temperatura:</span> {sensorData.temperatura} {sensorData.temperaturaMensagem}
            </li>
            <li>
              <span>Nível de Luz Solar:</span> {sensorData.nivelDeLuzSolar} {sensorData.nivelDeLuzSolarMensagem}
            </li>
            <li>
              <span>Quantidade de Adubo Usado:</span> {sensorData.quantidadeDeAduboUsado} {sensorData.quantidadeDeAduboUsadoMensagem}
            </li>
          </ul>
        </SensorCard>
      )}
      {!sensorData && <Loading/>}
    </ContainerSensor>
  );
};

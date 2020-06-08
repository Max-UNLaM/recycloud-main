use recycloud;
BEGIN;
INSERT INTO categoria(background_color, color, icon, nombre, short_desc) VALUES
('rgba(43,155,14,0.35)', '#0d380d', 'fa-recycle', 'Plásticos', 'Los plásticos abarcan una gran familia de materiales que se pueden
                            clasificar en varios tipos y reciclar de distintas manera'),
('rgba(232,208,0,0.35)', '#9b7e06', 'fa-box', 'Cartón', 'Material formado por la superposición de papeles');
INSERT INTO recycloud.categoria_entrenada(imagen, categoria_id)
VALUES('Tapa', 1),('CajaDeCigarrillos',2);



INSERT INTO categoria_informacion(como, descripcion, donde, tipos, categoria_id) VALUES
('Alguna de las propiedades de los materiales plásticos que pueden hacer variar su precio son las siguientes:\n

1. Transparencia y color: si lo que se compra es plástico de colores sólo se podrá reciclar para obtener productos plásticos de colores oscuros (grises, pardos, etc..) y por tanto se limita la utilidad de los mismos. Debido a este inconveniente el plástico de colores se vende más barato que el natural ó blanco.\n

2. Limpieza: mientras más limpio esté el plástico más valor adquiere en el mercado. Si los materiales vienen impresos se reduce su precio ya que hay que eliminar las tintas o simplemente utilizarlos para hacer piezas de color oscuro.\n

3. Presentación:con este término nos referimos a la forma en que se va a vender el plástico recuperado. Normalmente cuanto más pequeños son los trozos mayor es el precio que adquieren. Los más caros son en forma de granza, después triturados y por último como retales.\n

4. Fluidez y procesabilidad: estas características son importantes para el procesado de las piezas. Están relacionadas con la estructura interna (molecular) del plástico y con los agentes químicos (aditivos) que se les añaden para imprimirles determinadas propiedades. Obviamente, contra más fluidos y fáciles de procesar sean mayor precio se pagará por ellos.\n

5. Resistencia: los recicladores tienen en cuenta la resistencia de los materiales a diferentes exposiciones, por ejemplo a la degradación térmica durante el procesado de piezas o, una vez que ya se han fabricado, la resistencia a los agentes externos(humedad, luz solar, etc..)\n

6. Clasificación: si los materiales plásticos recuperados han sido separados por colores o por rígidos y flexibles, o por botellas y films, etc, alcanzan mayor valor que si van mezclados ya que ahorran tiempo y gastos a las empresas recicladoras.',
'Los plásticos abarcan una gran familia de materiales que se pueden clasificar en varios tipos y reciclar de distintas maneras. En este apartado encontrará más información sobre los diversos tipos de plásticos y las aplicaciones y ventajas de cada uno.',
'',
'Tipos
1. PET (Polietileno tereftalato). El PET se utiliza principalmente en la producción de botellas para bebidas. A través de su reciclado se obtiene principalmente fibras para relleno de bolsas de dormir, alfombras, cuerdas y almohadas.\n

2. HDPE (Polietileno de alta densidad). El HDPE normalmente se utiliza en envases de leche, detergente, aceite para motor, etc. El HDPE tras reciclarse se utiliza para macetas, contenedores de basura y botellas de detergente.\n

3. PVC (Cloruro de polivinilo). El PVC es utilizado en botellas de champú, envases de aceite de cocina, artículos de servicio para casas de comida rápida, etc. El PVC puede ser reciclado como tubos de drenaje e irrigación.\n

4. LDPE (Polietileno de baja densidad). El LDPE se encuentra en bolsas de supermercado, de pan, plástico para envolver. El LDPE puede ser reciclado como bolsas de supermercado nuevamente.\n

5. PP (Polipropileno). El PP se utiliza en la mayoría de recipientes para yogurt, sorbetes, tapas de botella, etc. El PP tras el reciclado se utiliza como viguetas de plástico, peldaños para registros de drenaje, cajas de baterías para autos.\n

6. PS (Poliestireno). El PS se encuentra en tazas desechables de bebidas calientes y bandejas de carne. El PS puede reciclarse en viguetas de plástico, cajas de cintas para casetes y macetas.\n

7. OTROS. Generalmente indica que es una mezcla de varios plásticos. Algunos de los productos de este tipo de plástico son: botellas de ketchup para exprimir, platos para hornos de microondas, etc. Estos plásticos no se reciclan porque no se sabe con certeza qué tipo de resinas contienen.\n
',
1
),
('1. Los productos que se pueden dejar los depósitos son: periódicos, revistas, cajas o embalajes de cartón y bolsas de papel.\n

2. Por otro lado, lo que no debemos echar en ellos es el papel de cocina, las servilletas de papel que están manchadas, los tetra bricks, el papel de aluminio o sanitario, cartones manchados con grasa, así como las etiquetas adhesivas, las fotos y las radiografías.',
'El cartón es un material formado por la superposición de papeles, lo que le confiere una mayor resistencia y dureza frente al papel. Es uno de los elementos más utilizados en el sector del embalaje, ya sea en la construcción de cajas como en el diseño de moldes que se acoplan en el interior de éstas para la sujeción de las mercancías.',
'',
'1. Cartón sólido: También se le llama tabla de cartón. Es delgado y tiene una parte lisa revestida y suave para facilitar la impresión. Es plano y resistente al agua.\n

2. Cartón gráfico: Es muy fino y se emplea para la cobertura de cartón más espeso. Se obtiene presionando varias capas de papel untadas en adhesivo.\n

3. Cartón gris: También llamado cartón piedra por su dureza. Está fabricado con papel reciclado compacto y pegamento. Al ser tan resistente, puede ser reutilizado varias veces.\n

4. Cartón couché: Su superficie está cubierta por una o varias capas de papel más fino y coloreado. Puede ser fino, clásico o moderno.\n

5. Cartoncillo: Este tipo de cartón es fino por estar muy compactado, aunque es ligero al mismo tiempo. Permite la impresión sobre él con buena calidad y es una de las variantes del cartón más utilizadas en el embalaje, sobre todo para productos con gran volumen de ventas y consumo.\n

6. Cartón ondulado: Probablemente es el tipo de cartón utilizado en la industria del embalaje industrial por su resistencia y sus cualidades.\n',
2
);
COMMIT;

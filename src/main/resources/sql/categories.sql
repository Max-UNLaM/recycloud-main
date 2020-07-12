use recycloud;

INSERT INTO categoria(background_color, color, icon, nombre, short_desc) VALUES
('rgba(43,155,14,0.35)', '#0d380d', 'fa-recycle', 'Plásticos', 'Los plásticos abarcan una gran familia de materiales que se pueden clasificar en varios tipos y reciclar de distintas manera'),
('rgba(239,112,0,0.35)', '#EF7000', 'fa-box', 'Cartón', 'El reciclaje de cartón sigue un proceso muy similar al reciclaje de papel, por lo que se puede obtener separando correctamente este material, y depositándolo en los contenedores de color azul.'),
('rgba(231,16,94,0.35)', '#E7105E', 'fa-wine-bottle', 'Eco Botellas', 'es un envase plástico relleno de más plásticos limpios y secos, residuos que pueden ir desde envoltorios de alimentos hasta cualquier tipo de plástico'),
('rgba(5,151,211,0.35)', '#0597D3', 'fa-wine-glass', 'Vidrio', 'El vidrio es un material inorgánico duro, frágil, transparente y amorfo que se encuentra en la naturaleza, aunque también puede ser producido por el ser humano'),
('rgba(247,214,3,0.80)', '#2A2A2A', 'fa-coins', 'Tapitas', 'Pieza de plástico que se encuentra en la parte superior de un objeto y que sirve para cerrarlo o cubrirlo'),


('rgba(247,214,3,0.80)', '#2A2A2A', 'fa-coins', 'Textil', 'El reciclaje textil es el método de reutilización o reprocesamiento de ropa usada, material fibroso y restos de ropa del proceso de fabricación.'),
('rgba(247,214,3,0.80)', '#2A2A2A', 'fa-coins', 'Pilas y Baterías', 'El reciclaje de pilas y baterías es una actividad cuyo objetivo es reducir el número de pilas y baterías que son descartadas como residuo sólido urbano.'),
('rgba(247,214,3,0.80)', '#2A2A2A', 'fa-coins', 'Metal', 'Al reciclar la chatarra se reduce la contaminación del agua, aire y los desechos de la minería en un 70%.'),
('rgba(247,214,3,0.80)', '#2A2A2A', 'fa-coins', 'Electrónico', 'El reciclaje de ordenadores o reciclaje electrónico es la reutilización de ordenadores, o en su defecto el desmontaje de las piezas y su clasificación para su posterior reciclaje.'),
('rgba(247,214,3,0.80)', '#2A2A2A', 'fa-coins', 'Agua', 'La Reutilización Del Agua. Agua reciclada o de re uso es el proceso de convertir un flujo de residuos en el agua que se puede reutilizar para otros fines.'),
('rgba(247,214,3,0.80)', '#2A2A2A', 'fa-coins', 'Neumáticos', 'Los neumáticos reciclados se convierten en muchos productos útiles. Un producto común de los neumáticos reciclados es el combustible derivado del neumático.'),
('rgba(247,214,3,0.80)', '#2A2A2A', 'fa-coins', 'Basura Orgánica', 'El Reciclaje orgánico o de materia orgánica, es aquel en el que la materia a reciclar, proviende de desechos naturales como son los alimentos, hojas, seres vivos o excrementos.');

INSERT INTO recycloud.usuario
(anio, apellido, dia, dni, email, identificacion, mes, nombre, password, rol)VALUES
(1999,'Núñez',20, 39272340,'admin@admin.com',0,'Diciembre','Tomas','admin123', 1),
(1995,'Morales',28, 39272340,'punto@punto.com',0,'Agosto','Nicolas','punto123', 3),
(1990,'Barrio Nuevo',17, 39272340,'generico@generico.com',0,'Abril','David','generico123', 2);


INSERT INTO recycloud.categoria_entrenada(imagen, categoria_id)
VALUES('VasoDePlastico', 1),('CajaDeCelular',2),('EcoBotella',3),('VasoDeVidrio',4),('TapaDePlastico',5);

INSERT INTO categoria_informacion(como, descripcion, donde, tipos, categoria_id) VALUES
('Alguna de las propiedades de los materiales plásticos que pueden hacer variar su precio son las siguientes:','Los plásticos abarcan una gran familia de materiales que se pueden clasificar en varios tipos y reciclar de distintas maneras. En este apartado encontrará más información sobre los diversos tipos de plásticos y las aplicaciones y ventajas de cada uno.','vacio','1. PET (Polietileno tereftalato). El PET se utiliza principalmente en la producción de botellas para bebidas. A través de su reciclado se obtiene principalmente fibras para relleno de bolsas de dormir, alfombras, cuerdas y almohadas.',1),
('1. Transparencia y color: si lo que se compra es plástico de colores sólo se podrá reciclar para obtener productos plásticos de colores oscuros (grises, pardos, etc..) y por tanto se limita la utilidad de los mismos. Debido a este inconveniente el plástico de colores se vende más barato que el natural ó blanco.','vacio','vacio','2. HDPE (Polietileno de alta densidad). El HDPE normalmente se utiliza en envases de leche, detergente, aceite para motor, etc. El HDPE tras reciclarse se utiliza para macetas, contenedores de basura y botellas de detergente.',1),
('2. Limpieza: mientras más limpio esté el plástico más valor adquiere en el mercado. Si los materiales vienen impresos se reduce su precio ya que hay que eliminar las tintas o simplemente utilizarlos para hacer piezas de color oscuro.','vacio','vacio','vacio',1),
('3. Presentación:con este término nos referimos a la forma en que se va a vender el plástico recuperado. Normalmente cuanto más pequeños son los trozos mayor es el precio que adquieren. Los más caros son en forma de granza, después triturados y por último como retales.','vacio','vacio','3. PVC (Cloruro de polivinilo). El PVC es utilizado en botellas de champú, envases de aceite de cocina, artículos de servicio para casas de comida rápida, etc. El PVC puede ser reciclado como tubos de drenaje e irrigación. 4. LDPE (Polietileno de baja densidad). El LDPE se encuentra en bolsas de supermercado, de pan, plástico para envolver. El LDPE puede ser reciclado como bolsas de supermercado nuevamente.',1),
('4. Fluidez y procesabilidad: estas características son importantes para el procesado de las piezas. Están relacionadas con la estructura interna (molecular) del plástico y con los agentes químicos (aditivos) que se les añaden para imprimirles determinadas propiedades. Obviamente, contra más fluidos y fáciles de procesar sean mayor precio se pagará por ellos.','vacio','vacio','5. PP (Polipropileno). El PP se utiliza en la mayoría de recipientes para yogurt, sorbetes, tapas de botella, etc. El PP tras el reciclado se utiliza como viguetas de plástico, peldaños para registros de drenaje, cajas de baterías para autos.',1),
('5. Resistencia: los recicladores tienen en cuenta la resistencia de los materiales a diferentes exposiciones, por ejemplo a la degradación térmica durante el procesado de piezas o, una vez que ya se han fabricado, la resistencia a los agentes externos(humedad, luz solar, etc..)','vacio','vacio','6. PS (Poliestireno). El PS se encuentra en tazas desechables de bebidas calientes y bandejas de carne. El PS puede reciclarse en viguetas de plástico, cajas de cintas para casetes y macetas.',1),
('6. Clasificación: si los materiales plásticos recuperados han sido separados por colores o por rígidos y flexibles, o por botellas y films, etc, alcanzan mayor valor que si van mezclados ya que ahorran tiempo y gastos a las empresas recicladoras.','vacio','vacio','7. OTROS. Generalmente indica que es una mezcla de varios plásticos. Algunos de los productos de este tipo de plástico son: botellas de ketchup para exprimir, platos para hornos de microondas, etc. Estos plásticos no se reciclan porque no se sabe con certeza qué tipo de resinas contienen',1);

INSERT INTO categoria_informacion(como, descripcion, donde, tipos, categoria_id) VALUES
('Los productos que se pueden dejar los depósitos son:','El cartón es un material formado por la superposición de papeles, lo que le confiere una mayor resistencia y dureza frente al papel. Es uno de los elementos más utilizados en el sector del embalaje, ya sea en la construcción de cajas como en el diseño de moldes que se acoplan en el interior de éstas para la sujeción de las mercancías.','vacio','1. Cartón sólido: También se le llama tabla de cartón. Es delgado y tiene una parte lisa revestida y suave para facilitar la impresión. Es plano y resistente al agua.',2),
('Periódicos, revistas, cajas o embalajes de cartón y bolsas de papel.','vacio','vacio','vacio',2),
('Por otro lado, lo que no debemos echar en ellos es el papel de cocina, las servilletas de papel que están manchadas, los tetra bricks, el papel de aluminio o sanitario, cartones manchados con grasa, así como las etiquetas adhesivas, las fotos y las radiografías.','vacio','vacio','2. Cartón gráfico: Es muy fino y se emplea para la cobertura de cartón más espeso. Se obtiene presionando varias capas de papel untadas en adhesivo.',2),
('vacio','vacio','vacio','3. Cartón gris: También llamado cartón piedra por su dureza. Está fabricado con papel reciclado compacto y pegamento. Al ser tan resistente, puede ser reutilizado varias veces.',2),
('vacio','vacio','vacio','4. Cartón couché: Su superficie está cubierta por una o varias capas de papel más fino y coloreado. Puede ser fino, clásico o moderno.',2),
('vacio','vacio','vacio','5. Cartoncillo: Este tipo de cartón es fino por estar muy compactado, aunque es ligero al mismo tiempo. Permite la impresión sobre él con buena calidad y es una de las variantes del cartón más utilizadas en el embalaje, sobre todo para productos con gran volumen de ventas y consumo.',2),
('vacio','vacio','vacio','6. Cartón ondulado: Probablemente es el tipo de cartón utilizado en la industria del embalaje industrial por su resistencia y sus cualidades.',2);

INSERT INTO categoria_informacion(como, descripcion, donde, tipos, categoria_id) VALUES
('Lavar bien y secar la botella. Es importante guardar la tapa para cuando se termine de llenar.','Una ecobotella es un envase plástico relleno de más plásticos limpios y secos, residuos que pueden ir desde envoltorios de alimentos hasta cualquier tipo de plástico','vacio','vacio',3),
('Otra recomendación a tener en cuenta es dejar la botella a mano para cuando haya que desechar los envoltorios.','vacio','vacio','vacio',3),
('Se puede armar un cesto aparte para que sea más práctico.Depositar los residuos en la botella.','vacio','vacio','vacio',3),
('Se necesita una varilla para compactar el material adentro. Hay que asegurarse de que todo esté limpio y seco.Una vez que el material esté bien compactado y cuando ya no entre nada más, volver a tapar la botella y guardarla para depositarla en alguno de los puntos limpios ubicados en la ciudad.','vacio','vacio','vacio',3);

INSERT INTO categoria_informacion(como, descripcion, donde, tipos, categoria_id) VALUES
('Previo a reciclar el vidrio, ya sea para tirarlo o reutilizarlo, es importante lavarlo.','El vidrio es un material inorgánico duro, frágil, transparente y amorfo que se encuentra en la naturaleza, aunque también puede ser producido por el ser humano. El vidrio artificial se usa para hacer ventanas, lentes, botellas y una gran variedad de productos. El vidrio es un tipo de material cerámico amorfo.','vacio','Se pueden reciclar frascos, perfumes, las botellas de bebidas, vinos y licores. No se pueden reciclar parabrisas, espejos, ampolletas, tubos fluorescentes, loza, pírex, cristales, vidrio templado y ventanas',4),
('Te recomendamos usar Cif Active Gel Limón Verde, con ultra poder desengrasante que hace que el lavado sea más fácil y rápido. Quitá todas las etiquetas o stickers del recipiente. Poné el recipiente en tu tacho de reciclaje o llévalo a un centro de reciclaje.','vacio','vacio','vacio',4),
('Algunos elementos de vidrio, como las lamparitas, tienen otro tipo de reciclaje.Podés reciclar vidrios rotos, pero tenés que tener cuidado.','vacio','vacio','vacio',4);

INSERT INTO categoria_informacion(como, descripcion, donde, tipos, categoria_id) VALUES
('vacio','Una tapa plastica es una parte de un contenedor, como un recipiente o una botella que sirve para cerrar o sellar y evitar que el contenido del recipiente se derrame o se fugue.','vacio','Tapas genéricas para botellas: Estas son de tipo rosca, a las cuales se les denomina cotidianamente taparrosca, o con cincho de seguridad. Son comúnmente utilizadas para el sellado de botellas de plástico que contienen agua, jugos, refresco, aceites, detergentes líquidos, etc.',5),
('vacio','vacio','vacio','Tapas flip-top: Son tapas de tipo dosificadoras y están disponibles en distintas medidas. Son utilizadas para los productos líquidos, semilíquidos y productos viscosos de las industrias farmacéutica, bebidas y cosméticos. Tienen aplicaciones para jugos, medicamentos, aderezos, shampos, jabones líquidos, etc.',5),
('vacio','vacio','vacio','Tapas disc top: La característica de este tipo de tapas es que al aplicar presión sobre uno de sus lados se levanta por el otro, habilitando una abertura por la que se permite dispersar el producto. Se encuentran disponibles en una gran variedad de modelos y colores para productos tales como, jabones líquidos, salsas, aderezos, medicamentos, etc.',5),
('vacio','vacio','vacio','Tapas tipo sport: Este tipo de tapas permite que el líquido pase por un orificio ubicado en su parte central, funcionan a través de presión. Son comúnmente empleadas para sellar contenedores de agua, sueros y bebidas energetizantes.',5);

INSERT INTO recycloud.evento
(direccion, fecha, hora_fin, hora_inicio, localidad, titulo, usuario_id)VALUES
('De los Incas 7546', '2020/06/30', '30:00', '16:00', 'Palermo', 'Clase en vivo de artesanias de reciclaje ', 2),
('Arieta 2720', '2020/06/29', '09:30', '20:00', 'Villa Luzuriaga', 'Charla informativa de como reciclar', 3),
('Belgrano 1458', '2020/07/01', '11:15', '19:00', 'Ramos Mejía', 'Reciclaje de EcoBotellas y productos reciclables', 2),
('Mosconi 546', '2020/07/01', '12:00', '15:00', 'San Justo', 'Festival del reciclaje', 2),
('De los Incas 7546', '2020/07/05', '10:00', '16:00', 'Palermo', 'Clase en vivo de artesanias de reciclaje ', 2),
('Arieta 2720', '2020/07/06', '09:30', '20:00', 'Villa Luzuriaga', 'Charla informativa de como reciclar', 3),
('Dr.Arturo Illia 5876', '2020/07/18', '11:30', '20:00', 'Isidro Casanova', 'Recolección de Tapitas', 3),
('Jujuy 2500', '2020/07/25', '10:30', '21:00', 'Flores', 'Recolección de Neutamicos', 3);

INSERT INTO recypoint
(amount, beneficiary_id, provider_id) VALUES
(1000, 1, 2);
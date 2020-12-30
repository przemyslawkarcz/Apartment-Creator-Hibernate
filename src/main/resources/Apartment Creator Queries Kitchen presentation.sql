/*

--This query (s) should be copied and pasted into the query editor in the H2 database,
--which is displayed in the browser at: http: //localhost:8080/h2-console/

--Kitchen presentation
select 
	kitchen.id ,
	kitchen.kitchen_name , 
	furniture.id, 
	furniture.furniture_name, 
	lighting_accessories.id, 
	lighting_accessories.lighting_accessory_name ,
	audio_video_items.id, 
	audio_video_item_name ,
	decorative_accessories.id , 
    decorative_accessories.decorative_accessories_name
from
	kitchen, 
	furniture, 
	lighting_accessories , 
	audio_video_items ,
	decorative_accessories
where
	kitchen.furniture_id = furniture.id
and
	kitchen.lighting_accessories_id = lighting_accessories.id 
and
	kitchen.audio_video_items_id = audio_video_items.id
and
	decorative_accessories.kitchen_id = kitchen.id;


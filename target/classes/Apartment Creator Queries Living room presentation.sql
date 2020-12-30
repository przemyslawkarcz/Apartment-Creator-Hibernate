/*

--This query (s) should be copied and pasted into the query editor in the H2 database,
--which is displayed in the browser at: http: //localhost:8080/h2-console/

--Living room presentation
select 
	living_room.id ,
	living_room.room_name , 
	furniture.id , 
	furniture.furniture_name , 
	lighting_accessories.id , 
	lighting_accessories.lighting_accessory_name ,
	audio_video_items.id , 
	audio_video_item_name ,
	decorative_accessories.id , 
    decorative_accessories.decorative_accessories_name
from
	living_room , 
	furniture , 
	lighting_accessories , 
	audio_video_items ,
	decorative_accessories
where
	living_room.furniture_id = furniture.id
and
	living_room.lighting_accessories_id = lighting_accessories.id 
and
	living_room.audio_video_items_id = audio_video_items.id
and	
    decorative_accessories.living_room_id = living_room.id;


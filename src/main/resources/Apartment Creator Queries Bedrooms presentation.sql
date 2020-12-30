/*

--This query (s) should be copied and pasted into the query editor in the H2 database,
--which is displayed in the browser at: http: //localhost:8080/h2-console/

--Bedrooms presentation

--Bedroom no. 1 presentation with id = 3 resulting from the order in which the rooms were created
select 
	bed_room.id ,
	bed_room.bed_room_name ,
	furniture.id , 
	furniture.furniture_name , 
	lighting_accessories.id , 
	lighting_accessories.lighting_accessory_name ,
	audio_video_items.id , 
	audio_video_item_name
 from 
	bed_room , 
	furniture , 
	lighting_accessories , 
	audio_video_items 
where 
	bed_room.id = 3 
and
	bed_room.furniture_id = furniture.id
and
	bed_room.lighting_accessories_id = lighting_accessories.id 
and
	bed_room.audio_video_items_id = audio_video_items.id ;

--Bedroom no. 2 presentation with id = 4 resulting from the order in which the rooms were created
select 
	bed_room.id ,
	bed_room.bed_room_name , 
	furniture.id , 
	furniture.furniture_name , 
	lighting_accessories.id , 
	lighting_accessories.lighting_accessory_name ,
	audio_video_items.id , 
	audio_video_item_name ,
	decorative_accessories.id , 
    decorative_accessories.decorative_accessories_name
from
	bed_room , 
	furniture , 
	lighting_accessories , 
	audio_video_items ,
	decorative_accessories
where
	bed_room.id = 4
and
	bed_room.furniture_id = furniture.id
and
	bed_room.lighting_accessories_id = lighting_accessories.id 
and
	bed_room.audio_video_items_id = audio_video_items.id
and
	decorative_accessories.bed_room_id = bed_room.id ;

--Bedroom no. 3 presentation with id = 5 resulting from the order in which the rooms were created
select 
	bed_room.id ,
	bed_room.bed_room_name ,
	furniture.id , 
	furniture.furniture_name , 
	lighting_accessories.id , 
	lighting_accessories.lighting_accessory_name ,
	audio_video_items.id , 
	audio_video_item_name
 from 
	bed_room , 
	furniture , 
	lighting_accessories , 
	audio_video_items 
where 
	bed_room.id = 5
and
	bed_room.furniture_id = furniture.id
and
	bed_room.lighting_accessories_id = lighting_accessories.id 
and
	bed_room.audio_video_items_id = audio_video_items.id ;


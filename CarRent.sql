PGDMP                      |        	   CarRental    16.4    16.4     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16399 	   CarRental    DATABASE     �   CREATE DATABASE "CarRental" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Hungarian_Hungary.1252';
    DROP DATABASE "CarRental";
                postgres    false            �            1259    32896    cars    TABLE     �   CREATE TABLE public.cars (
    id bigint NOT NULL,
    available boolean NOT NULL,
    price integer NOT NULL,
    type character varying(255)
);
    DROP TABLE public.cars;
       public         heap    postgres    false            �            1259    32895    cars_id_seq    SEQUENCE     �   ALTER TABLE public.cars ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.cars_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    216            �            1259    32902    cllients    TABLE     �   CREATE TABLE public.cllients (
    id bigint NOT NULL,
    address character varying(255),
    email character varying(255),
    name character varying(255),
    phone character varying(255)
);
    DROP TABLE public.cllients;
       public         heap    postgres    false            �            1259    32901    cllients_id_seq    SEQUENCE     �   ALTER TABLE public.cllients ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.cllients_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    218            �            1259    32910    rents    TABLE     �   CREATE TABLE public.rents (
    id bigint NOT NULL,
    end_date timestamp(6) without time zone,
    start_date timestamp(6) without time zone,
    car_id bigint,
    client_id bigint
);
    DROP TABLE public.rents;
       public         heap    postgres    false            �            1259    32909    rents_id_seq    SEQUENCE     �   ALTER TABLE public.rents ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.rents_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    220            �          0    32896    cars 
   TABLE DATA           :   COPY public.cars (id, available, price, type) FROM stdin;
    public          postgres    false    216   ~       �          0    32902    cllients 
   TABLE DATA           C   COPY public.cllients (id, address, email, name, phone) FROM stdin;
    public          postgres    false    218   �       �          0    32910    rents 
   TABLE DATA           L   COPY public.rents (id, end_date, start_date, car_id, client_id) FROM stdin;
    public          postgres    false    220          �           0    0    cars_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.cars_id_seq', 3, true);
          public          postgres    false    215            �           0    0    cllients_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.cllients_id_seq', 1, true);
          public          postgres    false    217            �           0    0    rents_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.rents_id_seq', 1, true);
          public          postgres    false    219            %           2606    32900    cars cars_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.cars
    ADD CONSTRAINT cars_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.cars DROP CONSTRAINT cars_pkey;
       public            postgres    false    216            '           2606    32908    cllients cllients_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.cllients
    ADD CONSTRAINT cllients_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.cllients DROP CONSTRAINT cllients_pkey;
       public            postgres    false    218            )           2606    32914    rents rents_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.rents
    ADD CONSTRAINT rents_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.rents DROP CONSTRAINT rents_pkey;
       public            postgres    false    220            *           2606    32920 !   rents fk2wr3q0xvwnrf6pqrgn1pbisyc    FK CONSTRAINT     �   ALTER TABLE ONLY public.rents
    ADD CONSTRAINT fk2wr3q0xvwnrf6pqrgn1pbisyc FOREIGN KEY (client_id) REFERENCES public.cllients(id);
 K   ALTER TABLE ONLY public.rents DROP CONSTRAINT fk2wr3q0xvwnrf6pqrgn1pbisyc;
       public          postgres    false    4647    220    218            +           2606    32915 !   rents fknt07d10bhaq3i8yjd26lnhcqf    FK CONSTRAINT     ~   ALTER TABLE ONLY public.rents
    ADD CONSTRAINT fknt07d10bhaq3i8yjd26lnhcqf FOREIGN KEY (car_id) REFERENCES public.cars(id);
 K   ALTER TABLE ONLY public.rents DROP CONSTRAINT fknt07d10bhaq3i8yjd26lnhcqf;
       public          postgres    false    220    216    4645            �   -   x�3�,�42 N�Ī�D.C ��w,M��2�L�44�sc���� �
�      �   G   x�3�t.�W(-INT��O�LK��N,���tH�M���K�����.�/RpIq��[[�q��qqq ��       �   (   x�3�4202�5��52T00�#���%B̐Ӑ+F��� ���     
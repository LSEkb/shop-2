package ru.skypro.homework.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.dto.Comment;
import ru.skypro.homework.entity.CommentEntity;

import java.time.Instant;

@Mapper
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    @Mapping(source = "author.pk", target = "author")
    @Mapping(source = "createdAtInst", target = "createdAt", qualifiedByName = "instantToLong")
    Comment commentToCommentDTO(CommentEntity commentEntity);

    @Mapping(source = "author", target = "author.pk")
    @Mapping(target = "ad", ignore = true)
    @Mapping(source = "createdAt", target = "createdAtInst", qualifiedByName = "longToInstant")
    CommentEntity commentDTOToComment(Comment commentDTO);


    @Named("longToInstant")
    public static Instant longToInstant(long createdAt) {
        return Instant.ofEpochMilli(createdAt);
    }

    @Named("instantToLong")
    public static Long instantToLong(Instant createdAtInst) {
        return createdAtInst.toEpochMilli();
    }
}
package site.hansi.jiacraft.module.product.api.comment;

import site.hansi.jiacraft.module.product.api.comment.dto.ProductCommentCreateReqDTO;
import site.hansi.jiacraft.module.product.service.comment.ProductCommentService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.annotation.Resource;

/**
 * 商品评论 API 实现类
 *
 * @author 北京智匠坊
 */
@Service
@Validated
public class ProductCommentApiImpl implements ProductCommentApi {

    @Resource
    private ProductCommentService productCommentService;

    @Override
    public Long createComment(ProductCommentCreateReqDTO createReqDTO) {
        return productCommentService.createComment(createReqDTO);
    }

}

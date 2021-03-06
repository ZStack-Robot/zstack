package org.zstack.network.service.vip

import org.zstack.header.query.APIQueryMessage

doc {
    title "QueryVip"

    category "vip"

    desc "查询VIP"

    rest {
        request {
            url "GET /v1/vips"

            url "GET /v1/vips/{uuid}"


            header(OAuth: 'the-session-uuid')

            clz APIQueryVipMsg.class

            desc "查询VIP"

            params APIQueryMessage.class
        }

        response {
            clz APIQueryVipReply.class
        }
    }
}
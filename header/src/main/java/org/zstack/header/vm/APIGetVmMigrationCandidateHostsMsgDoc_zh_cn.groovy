package org.zstack.header.vm

import org.zstack.header.vm.APIGetVmMigrationCandidateHostsReply

doc {
    title "GetVmMigrationCandidateHosts"

    category "vmInstance"

    desc "在这里填写API描述"

    rest {
        request {
			url "GET /v1/vm-instances/{vmInstanceUuid}/migration-target-hosts"


            header (OAuth: 'the-session-uuid')

            clz APIGetVmMigrationCandidateHostsMsg.class

            desc ""
            
			params {

				column {
					name "vmInstanceUuid"
					enclosedIn ""
					desc "云主机UUID"
					location "url"
					type "String"
					optional false
					since "0.6"
					
				}
				column {
					name "systemTags"
					enclosedIn ""
					desc ""
					location "query"
					type "List"
					optional true
					since "0.6"
					
				}
				column {
					name "userTags"
					enclosedIn ""
					desc ""
					location "query"
					type "List"
					optional true
					since "0.6"
					
				}
			}
        }

        response {
            clz APIGetVmMigrationCandidateHostsReply.class
        }
    }
}
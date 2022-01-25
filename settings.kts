import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.dockerCommand
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.sshExec
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2021.2"

project {

    vcsRoot(HttpsGithubComMikhailPukhovTeamCGitRefsHeadsMain)
    vcsRoot(HttpsGithubComMikhailPukhovTestAppGitRefsHeadsMain)

    buildType(Build)
}

object Build : BuildType({
    name = "Build"

    params {
        password("dockerPassword", "zxxf6717f82e71acd2ea91bc2d17124460b", display = ParameterDisplay.HIDDEN)
        password("sshkey", "zxx42be91b4740ef16f584d29f959bd40181917009da8036c30920328d46a060db952b1ce27b89596c45b6fa0ce43d8c3961adf9392014df5008baeeea1cf05c8696df1158039847f08febb1a22bc21919ce1dd512b3221967f156610a1a4793d4544043427e9ba36a4e8c6bb5f120d150991f74ec0163bd58f43e776c4b6af3d5eabcbc645ed44530b80df2ff1d9ea64834e4ca21377455db7b0939fafae4ef65975a5156c718bb0c87d366240790611e7e2eec9d3f85982f3be0b833e2c4f799685ad12aca8f6b41a72b0593dab8d16fbda25f002724332b58cf6ff29e17e30a1db25a614af7f7d3d836b0ca0d066626da9344dc1a7c197497f98d0f1fabfcedd337494fb2acc2b4411f8b03d9a85ea469d318bbbbd475a88f35c8bd79d44da2a2395737c10f57f41721fd8fbb7022540057f1f9d93f1115467272100340aafdc27c575bfb68cf56769892521c7485d255edfd8696542da4fa6f8ce3e0beb349a718bae8e905256e17c50304698cde70150ac3904c230b0f7b803785a0d43d44a4b894439675c2d401e0ca5d1693f258f322f5ab2610f12b7b314e89a1bf980f548df3a5ee457959d466848eb865c37c7d3048bddcf3baff53610494b7917b0a0c659b2584177a49257955a4c40f1a6383ae92f2f685d17014798c83286157c0532032d227e101d79df427adc1042a1ef0bd7766046c3f73817a1d372857b6c7569fc2e4c4a651dcb47a1b103fae0e5540f0f0be53ee3fe4a5e6f3d53ebcdae18a7d696c4bdd748b4db9477a361e8ad2f07f97161bca22dcd9cca5e0fa6ac8fe9e2e8d3c470fbe4a7a13afd5bdfefe0a1d611702c5da536127fbbdcbc41d19f08fc5ea039a744b712b74d8410758919c746b8242696b83740442eb4ef6ed18b8de34dc8da02b590b211713216d848b97311c3f3cb8d0c69efa789d878e8c97383bd95665547d7355005e7ad9610959273984184b1da4c5ded20089b1e3df612b6a0759ecfeecffe3a0c2cf9ed736f793dca858866c7de6770bb69eee38b20f7a0b2950e15a3ebbfcae299980ce2e9b89c0944392a9dc8c2c86f51ea4acbe2b843b6f09aaa1b6c16606f9dbe7c90fc6328b1aed6e4080d52fd228de25bf4ec1d9fb3bf468aa7676b60d62d3c4743140b6a274267eb9cdb7cbbab7f329285f2be81daf0568726733cbb5845cbf8ac3e82e610eb87ab5897fb4e57fea34af2604c3e1592e5f96449409e09b49bd54a817b669f072e59961aec20d1f01355708e8eeeb68db600138a5085b9a35c4a442d5baf54e083b44ae72be1c40cae9b1a5bbd395d0e972b7fd5d3676ab8714490b605d9dbb3ff357bb3b58a73c211031ac50845d2e24145856ef00d6c361c82bb272198211797da6fa9708937f5322accfe9fc67745b998fe79d84b5b81b30472340c622292f20dc2da15b78c670608c0e228a8c282acaa0931c1e0ad6aa7c831d90bf42da34616dbd1ac8d8a1625402963ced65aa0a7d4cc22c99c92bd61f7ef60909f8cc7ebc709fc617c4ef3f390bc58e0bad42e47f6b382ddcce710cc280e0e84838dcfbd9b8977320d508e3622854473c02be17bd642d8338fb8748b2a97f8062e5cc2e71ebffff4549a8d5e7e98176cb5fb1b2fc7cb10570f98c3ceb997275f98f2c5037ab47f97f5f6429f0437f3210eb5f26036bf87ac709186727a5d0aaaa1d1fbf33f48039673e136d02c1141fc6bae118f399ae912129c7ae401fd2d3d8ae70b325733d4659f15caf80358d8ee9eae74604fd7269259fbc06760f5e6c2fade59883409d09269c966d43690e4c72fefb254ded3184374c221ebb52d1062c6099cdc79dc0dad58bd6e86d7947c3dc80383789757ba637926fa9cdd1a5c39e130454b7f0e2c871e34dab5ecb18cdb63304687d417d3daa0e70e9a35f19892f2528f1719c26a91d8ca434eb13b33b7bc452fcbe3c692d0fa5d9fc10fcb30e803abe32a749bf04f77aaf62e0ce0c94270086aeec58689f908f33e394192916bbf2371bb1a37fb8fd46706f5e0cbc3688cb60fc541bab6e1922782aeacef88c777abfde0564cccfc54ec7e3d5ce8306f381bb73f1d6377a26f845cc06137a2ffe3540f1105fe04a24d3ae4451d7ccca66e8120cdb1f83169c181774c7c34e52272de650e5da3eb34cfa1378940e6095795dc27bdabf273940c9b65939ac9d6a25938c55257b844af4da00ce8c957a4bebb039d4ca859f4007b68cc24202e94af78258bdd126875b6137e2abb07ebcc6d54364b7eb9bdc6006c34e27c0f38a73f20294aaf14cf64c95ddb3af65918138a96f9618a1728bbf972a69448e3a85ce5f12b8c9cf73b30dd7b4df20a479916886598d949613a9c8afd6a6711e8a59bea1a8da230f1de63eb5ba726e20ec44d3a92387cab9fa35e9d765e7c2de23e300f13267d5de060de514d4b865c5e5f70e07e431c15585dc50d6c7b9a6bc10f1adf2cf310a62aecd7e08ed392a0f132bcafc610d0191dc51080e019ace758f01788cb44ac40b1653cad0888a3c3a6ae1ff5852dec0afb07dbb12163dc623aab325596cd3d0ff44970e9e70da9f1871d8b88ce40f781eed93cf6cee37ac6bd9fcb23ee8c2b1c6613f9750e569f2e7891b41eae2db2719b9d14f15c17157ee4fd9eba7a5d802b1cb62889507e0f8294a850a4fbbd47974e214ca7665fbb0dc3b506e6b6cb41d40fdf7f934123c1aebed397b92757a59bacf25bbb7c78239ca227470121f4ee43e18ca4517bb0de148fea5fac610884563cda8968d3dcb0217f00c52ed6c82c82d58a29594dff015fa3750e90cbef54b704c66581f0b6acdc867b942b1a03affa91b2509b6e4bc2d0eccf1642426814a85c8c10cc2ac2daeb24ccc9196ebad1543ec3c19ce0b3669b323d0355d94f8ebb8d019776afcf6fc759dcde22150989e85fcc89b974c1b9f3191bc0db1156bcf404696cdfc62f5e2fe670d69eacb09041872d0ece00013d48b26f1ed1770ae98b03f32af67a66bcbb8b9970b312169d10dedcf45c5491b8c531ddc3fa00a8799e31530e655314aec4e41ea94c5d061b39c36a75d543e79cbec2bd662e145cc700a6e0ece76b2604f725b0054f4189b40765d2bdd4f7a4969c067adaeb82c4c777d1c2002a641109bfbc762f8a397bffe90ea13f4c5241b9b51f2480f7c0ffcad2dfe369f76268727d7a5d8dc4bdf9e06f10589a0f435ad7db02de7013c9e625f994312d8d16d3bb7e89d13e6906363b7b23cf3cb316ed096b820f99ee12c45324a083a7d9b9fcc48cda4562f8afab8561251aec6c646f5f10d1518494f37dbcbf69a29c935dbb74c992ad3904496db4efc8eb4c857214d391b4facf39b7c55ec26f86ffabe5877e915dbe2b5752cded8d5dfde0ac073cba6d911c76356b382af7b84e7f5a7268efe0189baa3be922783e008dec1c13041221611a59ff6164254ce4347f916a80253f6a1cd0a2d36d7b85e50878d777e089f8415369c3da88643c68a713c6dc2f562172e97bce0c114f125d181b27dd96891f9b63f0e85f2fdc1f5d45f317847b25dd8b4fbc3baf", display = ParameterDisplay.HIDDEN)
        password("dockerLogin", "zxx5d11e144c4b02c5a8f491db7e47fd892", display = ParameterDisplay.HIDDEN)
    }

    vcs {
        root(HttpsGithubComMikhailPukhovTestAppGitRefsHeadsMain)
    }

    steps {
        dockerCommand {
            name = "docker img"
            commandType = build {
                source = file {
                    path = "Dockerfile"
                }
                namesAndTags = "mikkovrov/test_app:latest"
            }
        }
        dockerCommand {
            name = "docker login"
            commandType = other {
                subCommand = "login"
                commandArgs = "-u %dockerLogin% -p %dockerPassword%"
            }
        }
        dockerCommand {
            name = "docker push"
            commandType = push {
                namesAndTags = "mikkovrov/test_app:latest"
            }
        }
        sshExec {
            name = "deploy test_app"
            commands = "cd kube-prom/; kubectl delete -f manifests/test-app-dep.yaml; kubectl create -f manifests/test-app-dep.yaml"
            targetUrl = "3.141.37.253"
            authMethod = defaultPrivateKey {
                username = "ubuntu"
            }
            param("jetbrains.buildServer.sshexec.keyFile", "%sshkey%")
        }
    }

    triggers {
        vcs {
        }
    }
})

object HttpsGithubComMikhailPukhovTeamCGitRefsHeadsMain : GitVcsRoot({
    name = "https://github.com/mikhail-pukhov/TeamC.git#refs/heads/main"
    url = "https://github.com/mikhail-pukhov/TeamC.git"
    branch = "refs/heads/main"
    authMethod = password {
        userName = "mikhail-pukhov"
        password = "zxxf6717f82e71acd2ea91bc2d17124460b"
    }
})

object HttpsGithubComMikhailPukhovTestAppGitRefsHeadsMain : GitVcsRoot({
    name = "https://github.com/mikhail-pukhov/test_app.git#refs/heads/main"
    url = "https://github.com/mikhail-pukhov/test_app.git"
    branch = "refs/heads/main"
    branchSpec = "refs/heads/*"
    authMethod = password {
        userName = "mikhail-pukhov"
        password = "zxxf6717f82e71acd2ea91bc2d17124460b"
    }
})

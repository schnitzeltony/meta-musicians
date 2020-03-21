SUMMARY = "LSP (Linux Studio Plugins) is a collection of open-source plugins"
HOMEPAGE = "http://lsp-plug.in/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI = " \
    gitsm://github.com/sadko4u/lsp-plugins.git \
    file://0001-Add-missing-dsp-in-SUBDIRS.patch \
"
SRCREV = "cf3ff5d76c324ccb19a426cb23b87dccd71acb22"
S = "${WORKDIR}/git"
PV = "1.1.14"

do_configure[noexec] = "1"

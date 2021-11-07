SUMMARY = "NTK is a fork of FLTK"
SECTION = "libs"
LICENSE = "LGPLv2 & FLTK"
LIC_FILES_CHKSUM = "file://COPYING;md5=f6b26344a24a941a01a5b0826e80b5ca"

SRC_URI = " \
    git://github.com/falkTX/ntk.git;branch=master;protocol=https \
    file://0001-wscript-check-compile-instead-of-tun-check-datatype-.patch \
    file://0002-Fix-build-for-python3-only-environments.patch \
"
SRCREV = "720d8d33200ebd030df700c6c7a5a9cdf4581c03"
S = "${WORKDIR}/git"
PV = "1.3.1001"

inherit waf pkgconfig

DEPENDS = " \
    cairo \
    libpng \
    jpeg \
    zlib \
    libxft \
"

WAF_EXTRA_CONF = " \
    --libdir=${libdir} \
"

do_install:append() {
    rm ${D}${libdir}/libntk.a
    rm ${D}${libdir}/libntk.a.1
    mv ${D}${libdir}/libntk.a.${PV} ${D}${libdir}/libntk.a

    rm ${D}${libdir}/libntk_images.a
    rm ${D}${libdir}/libntk_images.a.1
    mv ${D}${libdir}/libntk_images.a.${PV} ${D}${libdir}/libntk_images.a
}

BBCLASSEXTEND = "native"

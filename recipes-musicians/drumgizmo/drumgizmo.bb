require ${BPN}.inc

inherit autotools-brokensep pkgconfig features_check gtk-icon-cache qemu-ext-musicians

REQUIRED_DISTRO_FEATURES = "x11"

DEPENDS += " \
    ${BPN}-native \
    libx11 \
    libxext \
    lv2 \
    libsmf \
    alsa-lib \
    libsndfile1 \
    zita-resampler \
    jack \
"

SRC_URI += " \
    file://0001-automake-enable-subdir-objects.patch \
    file://0002-Use-native-rcgen.patch \
    file://0003-Do-not-create-Manifest.ttl-with-cross-ttlgen.patch \
    file://0004-Fix-build-with-lv2-1.1.18.patch \
    file://drumgizmo.desktop \
"

# --disable-editor: sigh - editor requires Qt4
EXTRA_OECONF = " \
    --enable-lv2 \
    --without-debug \
    --disable-sse \
"

do_compile_append() {
    # build manifest.ttl
    cd ${B}/plugin
    ${@qemu_run_binary_local(d, '${STAGING_DIR_TARGET}', 'ttlgen')} .libs/drumgizmo.so manifest.ttl || echo "ERROR: at QEMU for ttlgen"
}

do_install_append() {
    install -d ${D}${datadir}/pixmaps
    install -m 0644 ${S}/plugingui/resources/logo.png ${D}${datadir}/pixmaps/drumgizmo-logo.png

    install -d ${D}${datadir}/applications
    install -m 0644 ${WORKDIR}/${BPN}.desktop ${D}${datadir}/applications/
}

FILES_${PN} += "${libdir}/lv2"
